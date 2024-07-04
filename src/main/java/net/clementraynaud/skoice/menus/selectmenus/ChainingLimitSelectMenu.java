/*
 * Copyright 2020, 2021, 2022, 2023, 2024 Clément "carlodrift" Raynaud, Lucas "Lucas_Cdry" Cadiry and contributors
 *
 * This file is part of Skoice.
 *
 * Skoice is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Skoice is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Skoice.  If not, see <https://www.gnu.org/licenses/>.
 */

package net.clementraynaud.skoice.menus.selectmenus;

import net.clementraynaud.skoice.Skoice;
import net.clementraynaud.skoice.menus.MenuEmoji;
import net.clementraynaud.skoice.storage.config.ConfigField;
import net.dv8tion.jda.api.interactions.components.selections.SelectOption;
import net.dv8tion.jda.api.interactions.components.selections.StringSelectMenu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChainingLimitSelectMenu extends SelectMenu {

    public static final String DISABLED = "disabled";
    public static final String SHORT = "short";
    public static final String MEDIUM = "medium";
    public static final String LONG = "long";

    public ChainingLimitSelectMenu(Skoice plugin) {
        super(plugin);
    }

    @Override
    public net.dv8tion.jda.api.interactions.components.selections.SelectMenu get() {
        List<SelectOption> options = new ArrayList<>(Arrays.asList(SelectOption.of(super.plugin.getBot().getLang().getMessage("menu.chaining-limit.select-menu.disabled.label"), ChainingLimitSelectMenu.DISABLED)
                        .withEmoji(MenuEmoji.PROHIBITED.get()),
                SelectOption.of(super.plugin.getBot().getLang().getMessage("menu.chaining-limit.select-menu.short.label"), ChainingLimitSelectMenu.SHORT)
                        .withEmoji(MenuEmoji.CHAINS.get()),
                SelectOption.of(super.plugin.getBot().getLang().getMessage("menu.chaining-limit.select-menu.medium.label"), ChainingLimitSelectMenu.MEDIUM)
                        .withEmoji(MenuEmoji.CHAINS.get())
                        .withDescription(super.plugin.getBot().getLang().getMessage("select-option.default.description")),
                SelectOption.of(super.plugin.getBot().getLang().getMessage("menu.chaining-limit.select-menu.long.label"), ChainingLimitSelectMenu.LONG)
                        .withEmoji(MenuEmoji.CHAINS.get())));

        String defaultValue = super.plugin.getConfigYamlFile().getString(ConfigField.CHAINING_LIMIT.toString());

        return StringSelectMenu.create("chaining-limit-selection")
                .addOptions(options)
                .setDefaultValues(defaultValue).build();
    }
}
