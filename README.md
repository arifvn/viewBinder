### viewBinder [![](https://jitpack.io/v/potatocandie/viewBinder.svg)](https://jitpack.io/#potatocandie/viewBinder)
Library to make ViewBinding easier to implement.

This is just simpler version of these awesome articles.💙
- [Article by Kirill Rozov](https://proandroiddev.com/make-android-view-binding-great-with-kotlin-b71dd9c87719)
- [Article by Seanghay](https://proandroiddev.com/viewbinding-with-kotlin-property-delegate-c907682e24c9)

They have created more robust lib. You can check that out.

#### How to implement
1. Add it in your root build.gradle at the end of repositories
```
  allprojects {
      repositories {
        ...
        maven { url 'https://jitpack.io' }
      }
	}
```
2. Enable viewBinding in your `build.gradle` file
```
  android {
      ...
      ...

      buildFeatures {
          viewBinding true
      }

      defaultConfig {
        ...
      }
  }
```
3. Add these dependencies
```
implementation "androidx.lifecycle:lifecycle-runtime:2.2.0"
implementation "androidx.lifecycle:lifecycle-common-java8:2.2.0"
implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0"
implementation "androidx.lifecycle:lifecycle-livedata-ktx:2.2.0"

implementation 'com.github.potatocandie:viewBinder:0.1.0'
```
4. Using in Activity
```kotlin
  class MainActivity : AppCompatActivity() {
      // initialize binding
      private val binding: ActivityMainBinding by viewBinder()

      override fun onCreate(savedInstanceState: Bundle?) {
          super.onCreate(savedInstanceState)

          // use it as usual
          binding.btnCheckout.setOnClickListener {

          }
      }
  }
 ```
5. Using in Fragment
```kotlin
  class ProfileFragment : Fragment() {
      // initialize binding
      private val binding: FragmentProfileBinding by viewBinder()
     
      override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
          super.onViewCreated(view, savedInstanceState)
          
          // use it as usual
          binding.tvUsername.text = "John Doe"
      }
  }
```
