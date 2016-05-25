package pl.surecase.eu;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;
import de.greenrobot.daogenerator.ToMany;

public class MyDaoGenerator {

    public static Schema schema;

    public static void main(String args[]) throws Exception {
        schema = new Schema(3, "greendao");

        Entity worker = schema.addEntity("Worker");
        worker.addLongProperty("id").primaryKey().autoincrement();
        worker.addStringProperty("block");
        worker.addStringProperty("level");
        worker.addStringProperty("unit");
        worker.addStringProperty("faceImage");
        worker.addStringProperty("cardFrontImage");
        worker.addStringProperty("cardBackImage");
        worker.addIntProperty("uploaded");
        new DaoGenerator().generateAll(schema, args[0]);
    }

}
