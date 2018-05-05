package com.hsuaxo.rxtube;

public abstract class Jsonable {

    public String json() {
        return RxTube.gson.toJson(this);
    }
}