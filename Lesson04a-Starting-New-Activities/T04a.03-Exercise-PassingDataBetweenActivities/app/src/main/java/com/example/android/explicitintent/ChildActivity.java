/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.explicitintent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ChildActivity extends Activity {

    /* Field to store our TextView */
    private TextView mDisplayText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);

        /* Typical usage of findViewById... */
        mDisplayText = (TextView) findViewById(R.id.tv_display);

        Intent thisActivity = getIntent();

        if (thisActivity.hasExtra(Intent.EXTRA_TEXT)) {
            String text = thisActivity.getStringExtra(Intent.EXTRA_TEXT);
            mDisplayText.setText(text);

        }


        // TODO (4) Create an if statement to check if this Intent has the extra we passed from MainActivity

        // TODO (5) If the Intent contains the correct extra, retrieve the text

        // TODO (6) If the Intent contains the correct extra, use it to set the TextView text
    }
}