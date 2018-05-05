## RxTube

#### YouTube REST API wrapper based on RxJava and Retrofit

#### INSTALLATION

##### Gradle

```gradle
compile 'com.hsuaxo:rxtube:1.0.3'
```
##### Maven

```maven
<dependency>
    <groupId>com.hsuaxo</groupId>
    <artifactId>rxtube</artifactId>
    <version>1.0.3</version>
    <type>jar</type>
</dependency>
```
#### USAGE

```java
final RxTube tube = new RxTube("YOUR_YOUTUBE_API_KEY");
```

```java
tube.search(YTContentType.ANY, "cats in boxes", 50).subscribe(new YTObserver() {
    @Override
    public void onSubscribe(Disposable d) {
        System.out.println("SUBSCRIBED");
    }

    @Override
    public void onSuccess(YTResult r) {
        r.items.forEach((item) -> {
            System.out.println(item.type() + " / " + item.name() + " / " + item.url());
        });
    }

    @Override
    public void onError(Throwable e) {
        System.out.println("ERROR: " + e.getMessage());
    }
});
```

#### SEARCH FOR VIDEOS, CHANNELS OR PLAYLISTS

```java
YTContentType.VIDEO
YTContentType.CHANNEL
YTContentType.PLAYLIST
```

#### SHORTCUT SEARCH METHODS

```java
Single<YTResult> searchVideos(String searchText, int maxRecords)
Single<YTResult> searchVideos(String searchText)

Single<YTResult> searchChannels(String searchText, int maxRecords)
Single<YTResult> searchChannels(String searchText)

Single<YTResult> searchPlaylists(String searchText, int maxRecords)
Single<YTResult> searchPlaylists(String searchText)
```

#### LICENSE
MIT
