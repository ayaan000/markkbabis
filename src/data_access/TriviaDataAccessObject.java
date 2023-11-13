package data_access;

import java.io.File;

//TODO: Add interfaces it implements
public class TriviaDataAccessObject {

    private final File csvFile;

    //private final String category;

    public TriviaDataAccessObject (String csvPath) {

        csvFile = new File(csvPath);

    }

}
