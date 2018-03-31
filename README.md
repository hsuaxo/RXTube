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

MIT License

Copyright (c) 2018 Hamlet Suazo

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

