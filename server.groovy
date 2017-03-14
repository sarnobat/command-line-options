package test;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class CommandLineOptionsExample {

  public static void main(String[] args) {
    String port;
    _parseOptions: {
      Options options = new Options()
          .addOption("p", "port", true, "Here you can set parameter .")
          .addOption("h", "help", false, "show help.");

      // This doesn't work
      // options.addOption(Option.builder("p").argName("p").longOpt("port").required().build());

      try {
        CommandLine cmd = new DefaultParser().parse(options, args);
        port = cmd.getOptionValue("p", "4444");
        System.out.println("CommandLineOptionsExample.parse() - SRIDHAR: port = " + port);

        if (cmd.hasOption("h")) {
          // This prints out some help
          HelpFormatter formater = new HelpFormatter();

          formater.printHelp("Main", options);
          System.exit(0);
        }
      } catch (ParseException e) {
        e.printStackTrace();
      }
    }
  }
}