package Petrol_engine;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import DB_beta.maindb;
import DB_beta.maindb.Db_errno;
// import maindbf.maindb;
// import maindbf.maindb.Db_errno;
// Programmers interction database Engine
public class Petrol {
    public String _file_dbname;

    public Petrol(String name) {
        this._file_dbname = name;
    }

    public Petrol() {
    }

    public void Petrol_make(String name, String primarykey, String... args) {
        String _new_var_change_na = name.concat(".Petrol");
        this._file_dbname = _new_var_change_na;
        File File_name_new = new File(this._file_dbname);
        try {
            if (File_name_new.createNewFile()) {
                maindb _db_ins_sec = new maindb();
                if (_db_ins_sec.create_tb(this._file_dbname, primarykey, args) == Db_errno.EE_TABLE_CREATION_FAILED) {
                    System.err.println("Table Failed its Creation");
                }
            }
        } catch (IOException e) {
            System.out.println("Cannot Instantiate the database");
            e.printStackTrace();
        }
    }

    public Db_errno insert(String... args) {
        maindb _db_ins = new maindb();
        try {
            return _db_ins.insert_into_tb_UTH_i(this._file_dbname, args);
        } catch (IOException e) {
            System.out.println("Cannot be inserted check the input or the value which is present in the file");
            return Db_errno.EE_INTERNAL_EXECPTION_HANDLED;
        }
    }

    public ArrayList<String> query_one(String name, String field_name, String clstr) {
        maindb __db_inMbdb = new maindb();
        try {
            ArrayList<String> rt = __db_inMbdb.finder_unstable(_file_dbname, name, field_name, clstr);
            return rt;
        } catch (IOException e) {
            System.out.println("system cannot be queried due to invalid value passed by User");
        }
        return null;
    }

    public void replace(String name_exp, String valtochange, String field, String new_val) {
        maindb _db_insk = new maindb();
        try {
            _db_insk.change_cond_primary_key(_file_dbname, name_exp, valtochange, field, new_val);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        
    }
}