# android-testing-project
demo project which shows how to Unit Test using View/Presenter - unit testing with `JUnit`

##Why?
Basically we have two different version of android.jar files, 
- one which we use to develop with and
- another one which actually exists on the device

  `The version  we use for development contains all the code we use and need for writing apps. 
It doesn’t include any of the framework code and it’s pretty important to have framework code when it comes to creating an activity. 
This is what makes testing on android very difficult. The internal API’s responsible for creating and launching activities are only 
available on the device and if we are using a device its not a unit testing. :)`

####Related Explantion 
The Android.jar present in the Android sdk is different from Android.jar present on the actual device.
we do not have access to internal apis and hence creating and initializing activity is hard. we get error like method not mocked. 
If we set the the test options in gradle defaultReturnValues = true, we still get Null pointer exceptions.


## Mockito! - everyone's favorite mocking lib

  `dependencies{
      ...
      testCompile "org.mockito:mockito-core:1.+"
  }`

The main use of mockito is it helps us in writing unwanted code during testing!

##Roboelectric 
  Wow!!!!! Now I am able to test my activity directly
  
  `dependencies{
      ...
      testCompile 'org.robolectric:robolectric:3.1'
  }`
  
- Add the library in the gradle.build(app) 
- change the test runner.
- set up configuration.
  
It is a unit test framework, it "defangs" the android sdk jar so you can unit test drive the developement of 
android app. Roboelectric fix the basic unit testing issues disscussed above while creating the activity by rewriting android classes
as they are being loaded making it possible for them to run on computer like any other java application

Shadows is an important concept with respect to intents.

   

