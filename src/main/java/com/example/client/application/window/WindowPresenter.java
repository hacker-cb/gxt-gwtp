package com.example.client.application.window;

import com.example.client.place.NameTokens;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.presenter.slots.NestedSlot;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;

public class WindowPresenter extends Presenter<WindowPresenter.MyView, WindowPresenter.MyProxy> implements WindowUiHandlers {
    interface MyView extends View, HasUiHandlers<WindowUiHandlers> {
    }

    @NameToken(NameTokens.WINDOW)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<WindowPresenter> {
    }

    PlaceManager placeManager;

    @Inject
    WindowPresenter(
            EventBus eventBus,
            MyView view,
            MyProxy proxy,
            PlaceManager placeManager) {
        super(eventBus, view, proxy, RevealType.Root);

        this.placeManager = placeManager;

        getView().setUiHandlers(this);
    }

    @Override
    public void goHome() {
        this.placeManager.revealPlace(new PlaceRequest.Builder().nameToken(NameTokens.HOME).build());
    }
}
