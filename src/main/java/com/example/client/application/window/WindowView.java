package com.example.client.application.window;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.sencha.gxt.widget.core.client.Window;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.event.SelectEvent;

import javax.inject.Inject;


public class WindowView extends ViewWithUiHandlers<WindowUiHandlers> implements WindowPresenter.MyView {
    interface Binder extends UiBinder<Window, WindowView> {
    }

    @UiField
    Window window;

    @UiField
    TextButton button;

    @Inject
    WindowView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiHandler("button")
    public void handleSelect(SelectEvent event) {
        getUiHandlers().goHome();
    }
}
