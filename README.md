# MediaQuery
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/moe.tlaster/mediaquery/badge.svg)](https://maven-badges.herokuapp.com/maven-central/moe.tlaster/mediaquery)
[![compose-jb-version](https://img.shields.io/badge/compose--jb-1.2.0--alpha01--dev745-blue)](https://github.com/JetBrains/compose-jb)
![license](https://img.shields.io/github/license/Tlaster/MediaQuery)

![badge-android](https://img.shields.io/badge/Platform-Android-brightgreen)
![badge-ios](https://img.shields.io/badge/Platform-iOS-lightgray)
![badge-jvm](https://img.shields.io/badge/Platform-JVM-orange)
![badge-macOS](https://img.shields.io/badge/Platform-macOS-purple)

MediaQuery for Compose Multiplatform

# Setup
```
api("moe.tlaster:mediaquery:$safearea_version")
```
And wrap your App with `ProvideMediaQuery()` like this
```Kotlin
ProvideMediaQuery {
  App()
}
```

# Usage
You can get the media query by `LocalMediaQuery.current`


# LICENSE
```
MIT License

Copyright (c) 2022 Tlaster

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
```
