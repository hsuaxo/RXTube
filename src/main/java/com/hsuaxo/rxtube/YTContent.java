package com.hsuaxo.rxtube;

import com.google.gson.annotations.SerializedName;

public class YTContent extends Jsonable {

    private Id id;
    private Snippet snippet;

    public YTContentType type() {
        switch (id.kind) {
            case "youtube#video":
                return YTContentType.VIDEO;
            case "youtube#channel":
                return YTContentType.CHANNEL;
            case "youtube#playlist":
                return YTContentType.PLAYLIST;
            default:
                return YTContentType.ANY;
        }
    }

    public String id() {
        switch (type()) {
            case VIDEO:
                return id.videoId;
            case CHANNEL:
                return id.channelId;
            case PLAYLIST:
                return id.playlistId;
            default:
                return "";
        }
    }

    public String name() {
        return name(false);
    }

    public String name(boolean clean) {
        String name = snippet.title;
        if (clean) {
            name = name.replaceAll("[^a-zA-Z0-9&, _]", "");
        }
        return name;
    }

    public String description() {
        return snippet.description;
    }

    public String date() {
        return snippet.publishedAt;
    }

    public String channelName() {
        return snippet.channelTitle;
    }

    public String thumbnailUrl() {
        if (snippet.thumbnails != null) {
            return snippet.thumbnails.medium.url;
        } else {
            return "";
        }
    }

    public String url() {
        final String url = "https://www.youtube.com/";
        switch (type()) {
            case VIDEO:
                return url + "watch?v=" + id();
            case CHANNEL:
                return url + "channel/" + id();
            case PLAYLIST:
                return url + "watch?list=" + id();
            default:
                return "";
        }
    }

    public boolean isVideo() {
        return type().equals(YTContentType.VIDEO);
    }

    public boolean isChannel() {
        return type().equals(YTContentType.CHANNEL);
    }

    public boolean isPlaylist() {
        return type().equals(YTContentType.PLAYLIST);
    }

    private class Id {

        String kind;
        String videoId;
        String playlistId;
        String channelId;
    }

    private class Snippet {

        String publishedAt;
        String title;
        String description;
        Thumbnails thumbnails;
        String channelTitle;
    }

    private class Thumbnails {

        @SerializedName("default")
        Thumbnail _default;
        Thumbnail medium;
        Thumbnail high;
    }

    private class Thumbnail {

        String url;
        int width;
        int height;
    }
}
