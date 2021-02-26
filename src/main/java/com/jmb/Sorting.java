package com.jmb;

import org.apache.spark.sql.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Sorting {

    private static final Logger LOGGER = LoggerFactory.getLogger(Sorting.class);
    private static final String SPARK_FILES_FORMAT = "csv";
    private static final String PATH_RESOURCES_DF = "src/main/resources/spark-data/.csv";

    public static void main(String[] args) throws Exception {

        LOGGER.info("Application starting up");
        Sorting app = new Sorting();
        app.init();
        LOGGER.info("Application gracefully exiting...");
    }

    private void init() throws Exception {



        //Create the Spark Session
        SparkSession session = SparkSession.builder()
                .appName("Joins")
                .master("local").getOrCreate();

                //Ingest data from CSV file into a DataFrame
        Dataset<Row> df = session.read()
                .format(SPARK_FILES_FORMAT)
                .option("header", "true")
                .option("inferSchema", "true")
                .load(PATH_RESOURCES_DF);


    }

}
