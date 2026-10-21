/*
 * Hello Minecraft! Launcher
 * Copyright (C) 2021  huangyuhui <huanghongxun2008@126.com> and contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package org.jackhuang.hmcl.ui.main;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import org.jackhuang.hmcl.theme.Themes;
import org.jackhuang.hmcl.ui.FXUtils;
import org.jackhuang.hmcl.ui.WeakListenerHolder;
import org.jackhuang.hmcl.ui.construct.ComponentList;
import org.jackhuang.hmcl.ui.construct.LineButton;
import org.jackhuang.hmcl.ui.construct.SpinnerPane;

import static org.jackhuang.hmcl.util.i18n.I18n.i18n;


public class FeedbackPage extends SpinnerPane {

    private final WeakListenerHolder holder = new WeakListenerHolder();

    public FeedbackPage() {
        VBox content = new VBox();
        content.getStyleClass().add("spinner-pane-content");
        ScrollPane scrollPane = new ScrollPane(content);
        scrollPane.setFitToWidth(true);
        FXUtils.smoothScrolling(scrollPane);
        setContent(scrollPane);

        ComponentList groups = new ComponentList();
        {
            var maintainer1 = LineButton.createExternalLinkButton("https://github.com/WeepingDogel");
            maintainer1.setLargeTitle(true);
            maintainer1.setTitle("WeepingDogel");
            maintainer1.setSubtitle(i18n("about.author.statement"));
            holder.add(FXUtils.onWeakChangeAndOperate(Themes.darkModeProperty(), darkMode -> maintainer1.setLeading(darkMode
                    ? FXUtils.newBuiltinImage("/assets/img/github-white.png")
                    : FXUtils.newBuiltinImage("/assets/img/github.png"))));

            var maintainer2 = LineButton.createExternalLinkButton("https://github.com/xhdndmm");
            maintainer2.setLargeTitle(true);
            maintainer2.setTitle("xhdndmm");
            maintainer2.setSubtitle(i18n("about.author.statement"));
            holder.add(FXUtils.onWeakChangeAndOperate(Themes.darkModeProperty(), darkMode -> maintainer2.setLeading(darkMode
                    ? FXUtils.newBuiltinImage("/assets/img/github-white.png")
                    : FXUtils.newBuiltinImage("/assets/img/github.png"))));

            groups.getContent().setAll(maintainer1, maintainer2);
        }

        ComponentList feedback = new ComponentList();
        {
            var github = LineButton.createExternalLinkButton("https://github.com/xhdndmm/gozMCL/issues/new/choose");
            github.setLargeTitle(true);
            github.setTitle(i18n("contact.feedback.github"));
            github.setSubtitle(i18n("contact.feedback.github.statement"));

            holder.add(FXUtils.onWeakChangeAndOperate(Themes.darkModeProperty(), darkMode -> {
                github.setLeading(darkMode
                        ? FXUtils.newBuiltinImage("/assets/img/github-white.png")
                        : FXUtils.newBuiltinImage("/assets/img/github.png"));
            }));

            feedback.getContent().setAll(github);
        }

        content.getChildren().addAll(
                ComponentList.createComponentListTitle(i18n("contact.chat")),
                groups,
                ComponentList.createComponentListTitle(i18n("contact.feedback")),
                feedback
        );
    }
}
