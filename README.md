# Android Compatibility Library

This library project is intended to help you develop apps which take advantage of new Android features like the Action Bar, yet are still compatible with older releases.  The code is based on [Google's I/O 2011][https://code.google.com/p/iosched] app.

## Incorporation

1 Clone this repo
    git clone git@github.com:rharter/android-libcompat.git
2 Update your project to use this library
    android update project --path . --library ../relative/path/to/library
3 Subclass BaseActivity in your activities.
4 Write more documentation…