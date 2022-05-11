package com.example.forminputinformation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;


public class MainActivity extends AppCompatActivity {
    TextInputLayout studentIDContainer;
    TextInputLayout nameContainer;
    TextInputLayout citizenIDContainer;
    TextInputLayout phoneContainer;
    TextInputLayout emailContainer;
    TextInputLayout BODContainer;
    TextInputLayout addressContainer;
    TextInputLayout addressPresentContainer;
    TextInputLayout majorsContainer;
    TextInputLayout languageCodeContainer;
    TextInputEditText eStudentID;
    TextInputEditText eName;
    TextInputEditText eCitizenID;
    TextInputEditText ePhone;
    TextInputEditText eEmail;
    TextInputEditText eBOD;
    TextInputEditText eAddress;
    TextInputEditText eAddressPresent;
    RadioGroup radioGroup;
    ScrollView mainScrollView;
    Button buttonSubmit;
    Button button1;
    Button button2;
    TextView languageGroup;
    CheckBox agreeCheckBox;
    CheckBox checkboxC;
    CheckBox checkBoxJava;
    CheckBox checkboxPython;
    CheckBox checkboxJavaScript;
    CalendarView calendarView;
    String selectedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        studentIDContainer = findViewById(R.id.studentIDContainer);
        eStudentID = findViewById(R.id.eStudentID);
        nameContainer = findViewById(R.id.nameContainer);
        eName = findViewById(R.id.eName);
        citizenIDContainer = findViewById(R.id.citizenIDContainer);
        eCitizenID = findViewById(R.id.eCitizenID);
        phoneContainer = findViewById(R.id.phoneContainer);
        ePhone = findViewById(R.id.ePhone);
        emailContainer = findViewById(R.id.emailContainer);
        eEmail = findViewById(R.id.eEmail);
        BODContainer = findViewById(R.id.BODContainer);
        eBOD = findViewById(R.id.eBOD);
        addressContainer = findViewById(R.id.addressContainer);eAddress = findViewById(R.id.eAddress);
        addressPresentContainer = findViewById(R.id.addressPresentContainer);
        eAddressPresent = findViewById(R.id.eAddressPresent);
        radioGroup = findViewById(R.id.radioGroup);
        mainScrollView = findViewById(R.id.mainScrollView);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        languageGroup = findViewById(R.id.languageGroup);
        agreeCheckBox = findViewById(R.id.agreeCheckbox);
        majorsContainer = findViewById(R.id.majorsContainer);
        languageCodeContainer = findViewById(R.id.languageCodeContainer);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.buttonPickDate);
        checkboxC = findViewById(R.id.checkboxC);
        checkBoxJava = findViewById(R.id.checkboxJava);
        checkboxPython = findViewById(R.id.checkboxPython);
        checkboxJavaScript = findViewById(R.id.checkboxJavaScript);
        calendarView = findViewById(R.id.calendarView);

        eStudentID.addTextChangedListener(checkTextWatcher);
        eName.addTextChangedListener(checkTextWatcher);
        eCitizenID.addTextChangedListener(checkTextWatcher);
        ePhone.addTextChangedListener(checkTextWatcher);
        eEmail.addTextChangedListener(checkTextWatcher);
        eAddress.addTextChangedListener(checkTextWatcher);
        eAddressPresent.addTextChangedListener(checkTextWatcher);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                selectedDate = dayOfMonth + "/" + month + "/" + year;
            }
        });

        findViewById(R.id.buttonPickDate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectedDate != null ){
                    eBOD.setText(selectedDate);
                    eBOD.setBackgroundResource(R.drawable.strokeinputdefault);
                    eBOD.setTextColor(getResources().getColor(R.color.black));
                }
                BODContainer.setHelperText("");
            }
        });

    }

    TextWatcher checkTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            setInputOnchange(studentIDContainer, eStudentID);
            setInputOnchange(nameContainer, eName);
            setInputOnchange(citizenIDContainer, eCitizenID);
            setInputOnchange(phoneContainer, ePhone);
            setInputOnchange(emailContainer, eEmail);
            setInputOnchange(addressContainer, eAddress);
            setInputOnchange(addressPresentContainer, eAddressPresent);
            setHelperText(studentIDContainer, eStudentID);
            setHelperText(nameContainer, eName);
            setHelperText(citizenIDContainer, eCitizenID);
            setHelperText(phoneContainer, ePhone);
            setHelperText(emailContainer, eEmail);
            setHelperText(addressContainer, eAddress);
            setHelperText(addressPresentContainer, eAddressPresent);


        }

        @Override
        public void afterTextChanged(Editable s) {
            setInputError(studentIDContainer, eStudentID);
            setInputError(nameContainer, eName);
            setInputError(citizenIDContainer, eCitizenID);
            setInputError(phoneContainer, ePhone);
            setInputError(emailContainer, eEmail);
            setInputError(addressContainer, eAddress);
            setInputError(addressPresentContainer, eAddressPresent);
        }
    };

    public void setInputError(TextInputLayout textInputLayout, TextInputEditText textInputEditText) {
        if (textInputEditText.getText().toString().length() == 0 ) {
            textInputLayout.setBoxStrokeColor(getResources().getColor(R.color.red));
            textInputEditText.setBackgroundResource(R.drawable.strokeinputerror);
            textInputLayout.setHelperText("Please fill this information");
        } else {
            setInputDefault(textInputLayout, textInputEditText);
        }
    }

    public void setInputOnchange(TextInputLayout textInputLayout, TextInputEditText textInputEditText){
        textInputLayout.setBoxStrokeColor(getResources().getColor(R.color.green));
        textInputEditText.setBackgroundColor(getResources().getColor(R.color.white));
    }

    public void setInputDefault(TextInputLayout textInputLayout,TextInputEditText textInputEditText){
        textInputEditText.setBackgroundResource(R.drawable.strokeinputdefault);
    }

    public void setHelperText(TextInputLayout textInputLayout, TextInputEditText textInputEditText){
        if (textInputEditText.getText().toString() != null ){
            textInputLayout.setHelperText("");
        }

    }

    public void setFocus(TextInputLayout textInputLayout, TextInputEditText textInputEditText){
        mainScrollView.scrollTo((int)textInputLayout.getX(),(int)textInputLayout.getY());
        setInputError(textInputLayout, textInputEditText);
    }

    public boolean checkLength(TextInputEditText textInputEditText) {
        if (textInputEditText.getText().toString().length() == 0) return true;
        return false;
    }

    public void buttonSubmit(View view) {
        if (checkLength(eStudentID)) {
            setFocus(studentIDContainer, eStudentID);
        } else if (checkLength(eName)) {
            eStudentID.clearFocus();
            setFocus(nameContainer, eName);
        } else if (checkLength(eCitizenID)) {
            eName.clearFocus();
            setFocus(citizenIDContainer, eCitizenID);
        } else if (checkLength(ePhone)) {
            eCitizenID.clearFocus();
            setFocus(phoneContainer, ePhone);
        } else if (checkLength(eEmail)) {
            ePhone.clearFocus();
            setFocus(emailContainer, eEmail);
        } else if (checkLength(eBOD)) {
            mainScrollView.scrollTo((int)BODContainer.getX(), (int)BODContainer.getY());
            setInputError(BODContainer, eBOD);
            eBOD.setText("Please choose your date");
            eBOD.setTextColor(getResources().getColor(R.color.red));
        }else if (checkLength(eAddress)) {
            eEmail.clearFocus();
            setFocus(addressContainer, eAddress);
        } else if (checkLength(eAddressPresent)) {
            eAddress.clearFocus();
            setFocus(addressPresentContainer, eAddressPresent);
        } else if (!(button1.isActivated() || button2.isActivated())) {
            mainScrollView.scrollTo((int)majorsContainer.getX(), (int)majorsContainer.getY());
            majorsContainer.setHelperText("Please choose at least one");
        }
        if (!(checkboxJavaScript.isChecked() || checkboxPython.isChecked() || checkBoxJava.isChecked() || checkboxC.isChecked()) || (button1.isActivated() || button2.isActivated())) {
            majorsContainer.setHelperText("");
            mainScrollView.scrollTo((int)languageCodeContainer.getX(), (int)languageCodeContainer.getY());
            languageCodeContainer.setHelperText("Please choose at least one");
        } else if (!agreeCheckBox.isChecked()) {
            languageCodeContainer.setHelperText("");
            Toast.makeText(view.getContext(), "Please agree this condition", Toast.LENGTH_LONG).show();
        } else if(agreeCheckBox.isChecked()) {
            majorsContainer.setHelperText("");
            Toast.makeText(view.getContext(), "Submit successfully", Toast.LENGTH_LONG).show();
        }

    }

    public void setInitiateValue() {
        eStudentID.setText("");
        eName.setText("");
        eCitizenID.setText("");
        ePhone.setText("");
        eEmail.setText("");
        eAddress.setText("");
        eAddressPresent.setText("");
    }

}