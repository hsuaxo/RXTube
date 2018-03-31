RXTube
============

YouTube Data API wrapper based on RxJava and Retrofit.

Basic Usage
-

```java
final RXTube tube = new RXTube("YOUR_API_KEY");
```

```java
tube.search(YTContentType.ANY, "cats in boxes").subscribe(new YTObserver() {
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
```
