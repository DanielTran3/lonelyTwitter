/*
Copyright (c) 2016 Team 9, CMPUT301, University of Alberta - All Rights Reserved.
You may use, distribute, and copy all parts of this code under terms and conditions of
University of Alberta and the Code of Student Behaviour.
You can find the copy of license at http://www.github.com/Team09/...
For further information, contact me at dtran2@ualberta.ca
*/

package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * This is the main view class of LonelyTwitter project. <p> It handles all
 * user interactions as well as file manipulations.</p>
 * <pre> All the files are stored in the form of "json" files stored in Emulator,
 * accessible 		from Android Device Monitor</pre>
 * <code> Pseudo code sample:
 * open some file ... <br>
 * attach some text ... <br>
 * close the file.
 * </code>
 * <ul>
 * <li>an item</li>
 * <li>another item</li>
 * <li>yet another item</li>
 * <li>again an item</li>
 * <li>other item</li>
 * </ul>
 * <ol>
 * <li>an item</li>
 * <li>another item</li>
 * <li>yet another item</li>
 * <li>again an item</li>
 * <li>other item</li>
 * </ol>
 *
 * @author Daniel
 * @see NormalTweet
 * @since 1.0
 */
public class LonelyTwitterActivity extends Activity {

	/**
	 * This is the file name that is being saved / loaded and contains all the tweets.
	 * @see #loadFromFile()
	 * @see #saveInFile()
	 */
	private static final String FILENAME = "file.sav";

	/**
	 * This is the EditText allows users to type a message for their tweet.
	 * @see #onCreate(Bundle)
	 */
	private EditText bodyText;

	/**
	 * Linked to the adapter and is used to update the ListView containing the tweets
	 * @see #onCreate(Bundle)
	 * @see #onStart()
	 */
	private ListView oldTweetsList;

	/**
	 * Contains the list of tweets that gets manipulated when a tweet is added or cleared.
	 * tweetList contains the data that will be saved from and loaded to.
	 * @see #onCreate(Bundle)
	 * @see #onStart()
	 * @see #saveInFile()
	 * @see #loadFromFile()
	 */
	private ArrayList<Tweet> tweetList = new ArrayList<Tweet>();

	/**
	 * Defines the adapter that notifies oldTweetList when an update occurs
	 * @see #onStart()
	 * @see #onCreate(Bundle)
	 */
	private ArrayAdapter<Tweet> adapter;

	/** Called when the activity is first created.*/
	/**
	 * Creates the opening screen and allows the user to click a save button to save a tweet or
	 * click the clear button to clear a tweet.
	 * @param savedInstanceState
     */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		/* Create the save, or "Tweet" button. */
		Button saveButton = (Button) findViewById(R.id.save);
		saveButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
                bodyText.setText("");

				Tweet newTweet = new NormalTweet(text);

				tweetList.add(newTweet);
				adapter.notifyDataSetChanged();

				saveInFile();
			}
		});

		/* Clear all the tweets and their data. */
		Button clearButton = (Button) findViewById(R.id.clear);
		clearButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				setResult(RESULT_OK);
				tweetList.clear();
                adapter.notifyDataSetChanged();
				saveInFile();
			}
		});
	}

	/**
	 * When onStart() happens, data is loaded from the saved file (file.sav), and the array adapter
	 * for tweets is set.
	 */
	@Override
	protected void onStart() {
		super.onStart();
		loadFromFile();
		adapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweetList);
		oldTweetsList.setAdapter(adapter);
	}

	/**
	 * loadFileFrom() uses Gson to load data from file.sav, converting the data from Json format.
	 * Uses FileInputStream and BufferReader to read in the data
	 * @throws FileNotFoundException
	 */
	private void loadFromFile() {
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));

			Gson gson = new Gson();

			// Code from http://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt
			Type listType = new TypeToken<ArrayList<NormalTweet>>(){}.getType();

			tweetList = gson.fromJson(in,listType);

		} catch (FileNotFoundException e) {
			/* Create a brand new tweet list if we can't find the file. */
			tweetList = new ArrayList<Tweet>();
		}
	}

	/**
	 * This method saves tweets to FILE_NAME (file.sav) using Gson, converting the data into Json
	 * format.
	 * @throws FileNotFoundException
	 * @exception RuntimeException
	 */
	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					0);

			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

			Gson gson = new Gson();
			gson.toJson(tweetList, out);
			out.flush();

			fos.close();
		} catch (FileNotFoundException e) {
			/* Rethrow. */
			throw new RuntimeException(e);
		} catch (IOException e) {
			/* Rethrow. */
			throw new RuntimeException(e);
		}
	}
}