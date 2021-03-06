package com.sevendark.ai.plugin;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.DialogWrapper;
import com.sevendark.ai.plugin.ui.SqlToJooqDialog;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class SqlToJooqAction extends AnAction {

    private static final String Name = "SQL/Jooq Converter...";

    public SqlToJooqAction() {
        super(Name);
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent event) {
        SqlToJooqDialog dialog = new SqlToJooqDialog();
        DialogWrapper dialogWrapper = new DialogWrapper(event.getProject()) {
            {
                init();
                setTitle("SQL <-> Jooq");
            }

            @Nullable
            @Override
            public JComponent getPreferredFocusedComponent() {
                return dialog.getPreferredFocusedComponent();
            }

            @NotNull
            @Override
            protected Action[] createActions() {
                return new Action[0];
            }

            @Nullable
            @Override
            protected JComponent createCenterPanel() {
                return dialog.getCenterPanel();
            }

        };
        dialogWrapper.setSize(730, 460);
        dialogWrapper.show();
    }
}
