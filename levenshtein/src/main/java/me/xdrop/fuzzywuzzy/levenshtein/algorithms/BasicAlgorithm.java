package me.xdrop.fuzzywuzzy.levenshtein.algorithms;

import me.xdrop.fuzzywuzzy.functions.ScoringFunction;
import me.xdrop.fuzzywuzzy.functions.StringMapper;

public abstract class BasicAlgorithm implements ScoringFunction {

    private StringMapper<String> stringFunction;

    public BasicAlgorithm() {
        this.stringFunction = new DefaultStringFunction();
    }

    public BasicAlgorithm(StringMapper<String> stringFunction) {
        this.stringFunction = stringFunction;
    }

    public abstract int apply(String s1, String s2, StringMapper<String> stringProcessor);

    public Integer apply(String s1, String s2){

        return apply(s1, s2, this.stringFunction);

    }

    public BasicAlgorithm with(StringMapper<String> stringFunction){
        setStringFunction(stringFunction);
        return this;
    }

    public BasicAlgorithm noProcessor(){
        this.stringFunction = StringMapper.IDENTITY;
        return this;
    }

    void setStringFunction(StringMapper<String> stringFunction){
        this.stringFunction = stringFunction;
    }

    public StringMapper<String> getStringFunction() {
        return stringFunction;
    }
}
