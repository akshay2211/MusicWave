[![API](https://img.shields.io/badge/API-9%2B-blue.svg?style=flat-square)](https://android-arsenal.com/api?level=9)

# MusicWave
With MusicWave represent your Sound in a gradient colored Visualization


![](media/musicwave_image.png)
![](media/musicwave_gif.gif)


Usage
-----

Add Permission in Manifest file.
```xml
 <uses-permission android:name="android.permission.RECORD_AUDIO"/>
```
xml
```xml
    <ak.sh.ay.musicwave.MusicWave
         android:id="@+id/musicWave"
         android:layout_width="match_parent"
         android:layout_height="match_parent"
         app:colorGradient="true"
         app:endColor="@color/colorEnd"
         app:startColor="@color/colorStart"
         app:waveThickness="1" />
```
For single color wave
```xml
         app:colorGradient="false"
         app:waveColor="@color/colorAccent"
```
Refer Sample App for detailed description of usage

Download
--------

 [ ![Download](https://api.bintray.com/packages/fxn769/android_projects/Oblique/images/download.svg) ](https://bintray.com/fxn769/android_projects/MusicWave/_latestVersion)  or grab via Gradle:
```groovy
compile 'com.fxn769:musicwave:1.0'
```
or Maven:
```xml
<dependency>
  <groupId>com.fxn769</groupId>
  <artifactId>musicwave</artifactId>
  <version>1.0</version>
  <type>pom</type>
</dependency>
```
or ivy:
```xml
<dependency org='com.fxn769' name='musicwave' rev='1.0'>
  <artifact name='musicwave' ext='pom' ></artifact>
</dependency>
```

Snapshots of the development version are available in [Sonatype's `snapshots` repository][snap].



License
--------

    Copyright 2017 Akshay Sharma

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
 [snap]: https://oss.sonatype.org/content/repositories/snapshots/