import com.google.auto.service.AutoService;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;

@AutoService(Processor.class)
@SupportedAnnotationTypes(value = {"HtmlForm", "HtmlInput"})
public class HtmlProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        // получить типы с аннотацией HtmlForm
        Set<? extends Element> annotatedElements = roundEnv.getElementsAnnotatedWith(HtmlForm.class);
        for(Element annotatedElement: annotatedElements){
            //получаем полный путь для генерации html
            String path = HtmlProcessor.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            // User.class -> User.html
            path = path.substring(1) + annotatedElement.getSimpleName().toString() + ".html";
            Path out = Paths.get(path);
            try{
                BufferedWriter writer = new BufferedWriter(new FileWriter(out.toFile()));
                HtmlForm htmlForm = annotatedElement.getAnnotation(HtmlForm.class);
                writer.write("<form action='" + htmlForm.action() + "' method='" + htmlForm.method() + "'/>");
                writer.newLine();
                List<? extends Element> enclosedElements = annotatedElement.getEnclosedElements();
                for(Element enclosedElement: enclosedElements){
                    HtmlInput htmlInput = enclosedElement.getAnnotation(HtmlInput.class);
                    if(htmlInput != null){
                        writer.write("<input type = '" + htmlInput.type() + "' name = '" + htmlInput.type() + "' placeholder = '" + htmlInput.placeholder() + "'>");
                        writer.newLine();
                        writer.write("<br>");
                        writer.newLine();
                    }
                }
                writer.write("</form>");
                writer.flush();
                writer.close();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }
        return true;
    }
}
