<h1 align="center">NetworkListener</h1>

<p align="center">
  <a target="_blank" href="https://www.paypal.me/RX1226" title="Donate using PayPal"><img src="https://img.shields.io/badge/paypal-donate-yellow.svg" /></a>
</p>


A HomeKey Listener for Android.

*Inspired by [lengguangzhishen](https://github.com/lengguangzhishen)/**[HomeKeyListener](https://github.com/lengguangzhishen/HomeKeyListener)**

## How to use

1. Add the JitPack repository to your build file:
```
    allprojects {
        repositories {
            ...
            maven { url 'https://jitpack.io' }
        }
    }
```
2. Add the dependency:
```
    dependencies {
        implementation 'com.github.RX1226:homekeylistener:1.0.0'
    }
```



## Usage
Process flow
**note**
a. instance object and init, add listener

```
public class MainActivity extends AppCompatActivity {
    private HomeKeyListener homeKeyListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeKeyListener = new HomeKeyListener(this);
        homeKeyListener.setOnHomeKeyListener(() -> {
            Log.d(TAG, "click Home key");
        });

        //extension
        homeKeyListener.setSystemDialogListener(new SystemDialogListener() {
            @Override
            public void onHomeKey() {
                Log.d(TAG, "onHomeKey");
            }

            @Override
            public void onRecentApps() {
                Log.d(TAG, "onRecentApps");
            }

            @Override
            public void onDream() {
                Log.d(TAG, "onDream");
            }

            @Override
            public void onAssist() {
                Log.d(TAG, "onAssist");
            }

            @Override
            public void onVoiceInterAction() {
                Log.d(TAG, "onVoiceInterAction");
            }
        });
    }
}
```
b. register observer and unregister observer
```
    @Override
    protected void onResume() {
        super.onResume();
        homeKeyListener.register();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        homeKeyListener.unregister();
    }
```

## License
	Copyright 2020 RX1226
	
	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at
	
	   http://www.apache.org/licenses/LICENSE-2.0
	
	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
