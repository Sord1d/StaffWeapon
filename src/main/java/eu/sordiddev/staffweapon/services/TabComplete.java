package eu.sordiddev.staffweapon.services;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TabComplete implements TabCompleter {

    List<String> subcommands = new ArrayList<String>();


    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {

            if (subcommands.isEmpty()) {

                subcommands.add("get");
                subcommands.add("damage");
                subcommands.add("setfast");
                subcommands.add("setcharged");
                subcommands.add("setmob");

            }
        List<String> arguments = new ArrayList<String>();

            if (args.length == 1){

                for (String a : subcommands){
                    if (a.toLowerCase().startsWith(args[0].toLowerCase())){
                        arguments.add(a);
                    }
                }

                return arguments;
            }

        return null;

    }
}
