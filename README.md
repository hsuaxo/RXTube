RXTube
============

YouTube Data API wrapper based on RxJava and Retrofit.

<b>Basic Usage</b>

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

License
-------

    Copyright 2014 Laimonas Turauskas

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

