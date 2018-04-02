## RXTube

#### YouTube REST API wrapper based on RxJava and Retrofit

#### USAGE

```java
final RXTube tube = new RXTube("YOUR_YOUTUBE_API_KEY");
```

```java
tube.search(YTContentType.ANY, "cats in boxes", 50).subscribe(new YTObserver() {
    @Override
    public void onSubscribe(Disposable d) {
        System.out.println("SUBSCRIBED");
    }

    @Override
    public void onSuccess(YTResponse response) {
        response.items.forEach((item) -> {
            System.out.println(item.type() + " / " + item.name() + " / " + item.url());
        });
    }

    @Override
    public void onError(Throwable e) {
        System.out.println("ERROR: " + e.getMessage());
    }
});

// SEARCH ANY CONTENT, VIDEOS, CHANNELS OR PLAYLISTS

YTContentType.ANY
YTContentType.VIDEO
YTContentType.CHANNEL
YTContentType.PLAYLIST

// SHORTCUT METHODS

Single<YTResult> searchVideos(String searchText, int maxRecords)
Single<YTResult> searchVideos(String searchText)

Single<YTResult> searchChannels(String searchText, int maxRecords)
Single<YTResult> searchChannels(String searchText)

Single<YTResult> searchPlaylists(String searchText, int maxRecords)
Single<YTResult> searchPlaylists(String searchText)

```

#### LICENSE
MIT
