package ru.itis.app;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

@Parameters(separators = "=")
public class Args{
	@Parameter(names = {"--mode"})
	public String mode;

	@Parameter(names = {"--count"})
	public int count = 1;

	@Parameter(names = {"--files"})
	public String files;

	@Parameter(names = {"--folder"})
	public String folder;
}
