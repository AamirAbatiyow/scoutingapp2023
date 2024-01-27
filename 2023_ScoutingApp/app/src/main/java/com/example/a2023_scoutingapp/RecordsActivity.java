package com.example.a2023_scoutingapp;

public class RecordsActivity {
    public static class Info {
        //main activity
        public static String scoutName = "";
        public static String matchNumber = "";
        public static String teamNumber = "";
        public static String driverStation = "";
        public static int robotPosition = 0;
        public static int preloadedGamePiece = 0;
        //auto activity

        public static boolean mobility = false;
        public static int gridScoring = 0;
        public static int autoTopScoring = 0;
        public static int autoMidScoring = 0;
        public static int autoBotScoring = 0;
        public static String autoComment = "";
        public static int autoChargeStation = 0;
        //tele activity
        public static boolean died = false;
        public static boolean restarted = false;
        public static boolean broke = false;
        public static boolean playedDefense = false;
        public static boolean facedDefense = false;
        public static boolean fellOver = false;
        public static boolean righted = false;
        public static boolean cones = false;
        public static boolean cubes = false;
        public static boolean groundGrab = false;
        public static boolean substationGrab = false;
        public static boolean shelfGrab = false;
        public static int teleTopScoring = 0;
        public static int teleMidScoring = 0;
        public static int teleBotScoring = 0;
        public static int gamePieceScoring = 0;
        public static String teleComment = "";
        //endgame activity
        public static int endgameChargeStation = 0;
        public static String endgameComment = "";
        //true is 1 and false is 0
        public static int printBoolean(boolean checkBox) {
            if(checkBox == true){
                return 1;
            } else {
                return 0;
            }
        }

        public static String CreateJSON() {
            String json = String.format("{\"ScoName\": \"%s\",",scoutName);
            json += String.format("\"MNum\": \"%s\",",matchNumber);
            json += String.format("\"TNum\": \"%s\",",teamNumber);
            json += String.format("\"RPos\": \"%s\",",robotPosition);
            json += String.format("\"PLoad\": \"%s\",",preloadedGamePiece);
            json += String.format("\"Mob\": \"%d\",",printBoolean(mobility));
            json += String.format("\"AGrid\": \"%s\",",gridScoring);
            json += String.format("\"ATop\": \"%s\",",autoTopScoring);
            json += String.format("\"AMid\": \"%s\",",autoMidScoring);
            json += String.format("\"ABot\": \"%s\",",autoBotScoring);
            json += String.format("\"ACom\": \"%s\",",autoComment);
            json += String.format("\"ACharStat\": \"%s\",",autoChargeStation);
            json += String.format("\"Died\": \"%s\",",printBoolean(died));
            json += String.format("\"RStart\": \"%s\",",printBoolean(restarted));
            json += String.format("\"Broke\": \"%s\",",printBoolean(broke));
            json += String.format("\"DefPlay\": \"%s\",",printBoolean(playedDefense));
            json += String.format("\"DefFace\": \"%s\",",printBoolean(facedDefense));
            json += String.format("\"Fell\": \"%s\",",printBoolean(fellOver));
            json += String.format("\"Righted\": \"%s\",",printBoolean(righted));
            json += String.format("\"Cones\": \"%s\",",printBoolean(cones));
            json += String.format("\"Cubes\": \"%s\",",printBoolean(cubes));
            json += String.format("\"GroGrab\": \"%s\",",printBoolean(groundGrab));
            json += String.format("\"SubGrab\": \"%s\",",printBoolean(substationGrab));
            json += String.format("\"ShGrab\": \"%s\",",printBoolean(shelfGrab));
            json += String.format("\"TTop\": \"%s\",",teleTopScoring);
            json += String.format("\"TMid\": \"%s\",",teleMidScoring);
            json += String.format("\"TBot\": \"%s\",",teleBotScoring);
            json += String.format("\"GPiece\": \"%s\",",gamePieceScoring);
            json += String.format("\"TCom\": \"%s\",",teleComment);
            json += String.format("\"ECharSta\": \"%s\",",endgameChargeStation);
            json += String.format("\"ECom\": \"%s\",}",endgameComment);
            return json;
        }

        public static void clear() {
            //main activity
            matchNumber = "";
            teamNumber = "";
            robotPosition = 0;
            preloadedGamePiece = 0;

            //auto page
            autoTopScoring = 0;
            autoMidScoring = 0;
            autoBotScoring = 0;
            gridScoring = 0;
            mobility = false;
            autoComment = "";
            autoChargeStation = 0;

            //tele page
            died = false;
            restarted = false;
            broke = false;
            playedDefense = false;
            facedDefense = false;
            fellOver = false;
            righted = false;
            cones = false;
            cubes = false;
            groundGrab = false;
            substationGrab = false;
            shelfGrab = false;
            teleTopScoring = 0;
            teleMidScoring = 0;
            teleBotScoring = 0;
            gamePieceScoring = 0;
            teleComment = "";

            //end page
            endgameChargeStation = 0;
            endgameComment = "";
        }
    }
}
