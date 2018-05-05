package com.hsuaxo.rxtube;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public abstract class YTObserver implements SingleObserver<YTResult> {

    @Override
    public void onSubscribe(Disposable disposable) {
    }
}
