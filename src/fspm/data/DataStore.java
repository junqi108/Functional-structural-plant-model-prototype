package fspm.data;

public class DataStore {
    private static DataStore instance = null;

    // TODO: figure out how data is stored in current model

    public DataStore() {

    }

    public static DataStore getInstance() {
        if (instance == null) {
            instance = new DataStore();
        }

        return instance;
    }
}
