package com.hsuaxo.rxtube;

public enum YTContentType {
    ANY,
    VIDEO,
    CHANNEL,
    PLAYLIST;

    @Override
    public String toString() {
        switch (this) {
            case ANY: {
                return "video,channel,playlist";
            }
            default:
                return super.toString().toLowerCase();
        }
    }
}
