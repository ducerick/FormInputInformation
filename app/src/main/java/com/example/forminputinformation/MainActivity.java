package com.example.forminputinformation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;


public class MainActivity extends AppCompatActivity {
    int flagStudentID = 0;
    TextInputLayout studentIDContainer;
    TextInputEditText eStudentID;
    String studentID = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        studentIDContainer = findViewById(R.id.studentIDContainer);
        eStudentID = findViewById(R.id.eStudentID);
        TextInputLayout nameContainer = findViewById(R.id.nameContainer);
        TextInputEditText eName = findViewById(R.id.eName);
        TextInputLayout citizenIDContainer = findViewById(R.id.citizenIDContainer);
        TextInputEditText eCitizenID = findViewById(R.id.eCitizenID);
        TextInputLayout phoneContainer = findViewById(R.id.phoneContainer);
        TextInputEditText ePhone = findViewById(R.id.ePhone);
        TextInputLayout emailContainer = findViewById(R.id.emailContainer);
        TextInputEditText eEmail = findViewById(R.id.eEmail);
        TextInputLayout BODContainer = findViewById(R.id.BODContainer);
        TextInputEditText eBOD = findViewById(R.id.eBOD);
        TextInputLayout addressContainer = findViewById(R.id.addressContainer);
        TextInputEditText eAddress = findViewById(R.id.eAddress);
        TextInputLayout addressPresentContainer = findViewById(R.id.addressPresentContainer);
        TextInputEditText eAddressPresent = findViewById(R.id.eAddressPresent);
        RadioGroup radioGroup = findViewById(R.id.radioGroup);

        eStudentID.addTextChangedListener(checkTextWatcher);
    }

    private final TextWatcher checkTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
             studentID = eStudentID.getText().toString();
             if (studentID != null) {
                 studentIDContainer.setHelperText("");
             }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };


    public void buttonSubmit(View view) {
        if (studentID == null) {
            studentIDContainer.setBackgroundResource(R.drawable.strokeinput);
            studentIDContainer.setHelperText("Please fill this information");
            eStudentID.forceLayout();
            eStudentID.setBackground(null);
        }
    }
}