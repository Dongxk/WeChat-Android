package com.example.dongxiangkun.wechat_android.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Parcelable;
import android.support.v7.view.menu.BaseMenuPresenter;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuView;

public class BasePresenter extends BaseMenuPresenter {
    /**
     * Construct a new BaseMenuPresenter.
     *
     * @param context       Context for generating system-supplied views
     * @param menuLayoutRes Layout resource ID for the menu container view
     * @param itemLayoutRes Layout resource ID for a single item view
     */
    @SuppressLint("RestrictedApi")
    public BasePresenter(Context context, int menuLayoutRes, int itemLayoutRes) {

        super(context, menuLayoutRes, itemLayoutRes);
    }

    @Override
    public void bindItemView(MenuItemImpl item, MenuView.ItemView itemView) {

    }

    @Override
    public Parcelable onSaveInstanceState() {
        return null;
    }

    @Override
    public void onRestoreInstanceState(Parcelable state) {

    }
}
