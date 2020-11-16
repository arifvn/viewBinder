### viewBinder [![](https://jitpack.io/v/potatocandie/viewBinder.svg)](https://jitpack.io/#potatocandie/viewBinder)
Library to make ViewBinding easier to implement.

This is just simpler version of these awesome articles.💙
- [Article by Kirill Rozov](https://proandroiddev.com/make-android-view-binding-great-with-kotlin-b71dd9c87719)
- [Article by Seanghay](https://proandroiddev.com/viewbinding-with-kotlin-property-delegate-c907682e24c9)
They have created more robust lib. You can check that out.

#### How to implement
1. Enable viewBinding in your `build.gradle` file
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
2. Add these dependencies
```
  implementation "androidx.lifecycle:lifecycle-livedata-ktx:x.y.z"
  implementation "androidx.lifecycle:lifecycle-common-java8:x.y.z"
```
3. Using in Activity
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
4. Using in Fragment
```kotlin
  class ProfileFragment : Fragment() {

      private val binding: FragmentProfileBinding by viewBinder()

      override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
          super.onViewCreated(view, savedInstanceState)

          binding.tvUsername.text = "John Doe"
      }
  }
```
