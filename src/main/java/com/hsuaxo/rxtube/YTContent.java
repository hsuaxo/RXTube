package com.hsuaxo.rxtube;


import com.google.gson.annotations.SerializedName;

public class YTContent {
    private Id id;
    private Snippet snippet;

//    public String id() {
//        if (type().equals(ContentType.YOUTUBE_VIDEO)) {
//            return id.videoId;
//        } else {
//            return id.playlistId;
//        }
//    }

    public String name() {
        return name(false).toUpperCase();
    }

    public String name(boolean clean) {
        String name = snippet.title;
        if (clean) {
            name = name.replaceAll("[^a-zA-Z0-9&, _]", "");
        }
        return name;
    }

    public String channel() {
        return snippet.channelTitle;
    }

    public String thumbnail() {
        if (snippet.thumbnails != null) {
            return snippet.thumbnails.medium.url;
        } else {
            return null;
        }
    }

//    public Uri url() {
//        if (type().equals(ContentType.YOUTUBE_VIDEO)) {
//            return Uri.parse("https://www.youtube.com/watch?v=" + id());
//        } else {
//            return Uri.parse("https://www.youtube.com/watch?list=" + id());
//        }
//    }

//    public boolean isPlaylist() {
//        return type().equals(ContentType.YOUTUBE_PLAYLIST);
//    }

    private class Id {
        String kind;
        String videoId;
        String playlistId;
    }

    private class Snippet {
        String title;
        Thumbnails thumbnails;
        String channelTitle;
    }

    private class Thumbnails {
        @SerializedName("default")
        Thumbnail medium;
    }

    private class Thumbnail {
        String url;
    }

//    public Content content() {
//        return Content.youtube(this);
//    }
}