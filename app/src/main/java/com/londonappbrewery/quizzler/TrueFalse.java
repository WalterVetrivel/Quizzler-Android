package com.londonappbrewery.quizzler;

class TrueFalse {
    private int mQuestionNumber;
    private boolean mAnswer;

    public TrueFalse(int questionNumber, boolean answer) {
        this.mQuestionNumber = questionNumber;
        this.mAnswer = answer;
    }

    public int getQuestionNumber() {
        return mQuestionNumber;
    }

    public boolean isAnswer() {
        return mAnswer;
    }

    public void setQuestionNumber(int questionNumber) {
        this.mQuestionNumber = questionNumber;
    }

    public void setAnswer(boolean answer) {
        this.mAnswer = answer;
    }
}
