package labs_examples.objects_classes_methods.labs.oop.D_my_oop;

import java.util.Scanner;

public class InstrumentSimulatorController {
    Pianos yourPiano = new Pianos("Korg", true, 112);
    Guitars myGuitar = new Guitars("Jackson", true, 24);
    CurrentInstrument currentInstrument = new CurrentInstrument();
    boolean applicationRunning = true;


    public static void main(String[] args) {
        InstrumentSimulatorController controller = new InstrumentSimulatorController();
        while(controller.applicationRunning) {
            controller.chooseCurrentInstrument();
            controller.testInstrumentOut();
            if(controller.applicationRunning) {
                controller.currentInstrument.userPlays();
            }
        }
    }


    public void chooseCurrentInstrument(){
        Scanner selectInstrument = new Scanner(System.in);
        System.out.println("Press \"k\" to play the Korg synth piano, \"j\" to play the Jackson electric guitar, or \"x\" to quit.");
        char userChoice = selectInstrument.next().charAt(0);
        switch(userChoice){
            case 'k':
                currentInstrument.setCurrentInstrument(yourPiano);
                break;
            case 'j':
                currentInstrument.setCurrentInstrument(myGuitar);
                break;
            case 'x':
                System.out.println("Goodbye!");
                applicationRunning = false;
                break;
            default:
                System.out.println("Invalid input -- You're forced to play the guitar.");
                currentInstrument.setCurrentInstrument(myGuitar);
                break;
        }

    }

    public void testInstrumentOut(){
        if(applicationRunning) {
            System.out.println("You begin by testing out the instrument: ");
            currentInstrument.playCurrentInstrument();
        }else{
            return;
        }
    }



}

class CurrentInstrument{
    private PlayInstrument currentInstrument;

    public void playCurrentInstrument(){
        currentInstrument.playCMajorChord();
        currentInstrument.playCMajorScale();
        currentInstrument.playLostWoodsIntro();
    }

    public void userPlays(){
        currentInstrument.printInstructions();
        currentInstrument.takeUserInputAndPlay();
    }

    public CurrentInstrument() {
    }

    public CurrentInstrument(PlayInstrument currentInstrument) {
        this.currentInstrument = currentInstrument;
    }

    public void setCurrentInstrument(PlayInstrument currentInstrument) {
        this.currentInstrument = currentInstrument;
    }


}

interface PlayInstrument{

    public void playCMajorScale();
    public void playCMajorChord();
    public void playLostWoodsIntro();
    public void takeUserInputAndPlay();
    public void octaveUp();
    public void octaveDown();
    public void printInstructions();

}

class Instruments{

    private static String[] notes = {"A", "A#", "B", "C", "C#", "D", "D#","E", "F", "F#", "G", "G#"};
    private static int[] octaves = {0,1,2,3,4,5,6,7,8};
    Scanner userInput = new Scanner(System.in);

    void tuneInstrument(){
        System.out.println("You tune your instrument back into the correct pitch.");
    }

    public void playMelody(int bpm, int octave, int note1, int note2, int note3){
        System.out.println("You play " + notes[note1] + " " + notes[note2]
                + " " + notes[note3] + " at " + bpm + " beats per minute in the " + octaves[octave] + "th octave.");
    }
    public void playMelody(int bpm, int octave, int note1, int note2, int note3, int note4){
        System.out.println("You play " + notes[note1] + " " + notes[note2]
                + " " + notes[note3] + " " + notes[note4] + " at " + bpm +
                " beats per minute in the " + octaves[octave] + "th octave.");
    }

    public void playMelody(int bpm, int octave, int note1, int note2, int note3, int note4, int note5){
        System.out.println("You play " + notes[note1] + " " + notes[note2]
                + " " + notes[note3] + " " + notes[note4] + " " + notes[note5] + " at " + bpm +
                " beats per minute in the " + octaves[octave] + "th octave.");
    }

    public static String playNoteAtOctave(int note, int octave){
        return notes[note] + octaves[octave];
    }

    public static String[] getNotes() {
        return notes;
    }


    public static int[] getOctaves() {
        return octaves;
    }

}

class Guitars extends Instruments implements PlayInstrument{

    private String manufacturer;
    private boolean isElectric;
    private int numFrets;
    private int thisOctave = 0;

    public void octaveUp(){
        if(thisOctave < 8){
            thisOctave +=1;
        }else{
            System.out.println("You are already at the highest octave.");
        }
    }

    public void octaveDown(){
        if(thisOctave > 0){
            thisOctave -=1;
        }else{
            System.out.println("You are already at the lowest octave.");
        }
    }

    public void printInstructions(){
        System.out.println("You can play the guitar by using the following keys for the following notes and actions: \n" +
                "z=A, s=A#, e=B, x=C, d=C#, r=D, c=D#, f=E, t=F, v=F#, g=G, y=G# \n" +
                "Press \"m\" to go up an octave and \"n\" to go down an octave | Press \"p\" to stop playing.");
    }

    public void takeUserInputAndPlay(){
        char noteChar;
        int note = 0;
        boolean keepPlaying = true;
        while(keepPlaying) {
            noteChar = userInput.next().charAt(0);
            switch (noteChar) {
                case 'z':
                    note = 0;
                    break;
                case 's':
                    note = 1;
                    break;
                case 'e':
                    note = 2;
                    break;
                case 'x':
                    note = 3;
                    break;
                case 'd':
                    note = 4;
                    break;
                case 'r':
                    note = 5;
                    break;
                case 'c':
                    note = 6;
                    break;
                case 'f':
                    note = 7;
                    break;
                case 't':
                    note = 8;
                    break;
                case 'v':
                    note = 9;
                    break;
                case 'g':
                    note = 10;
                    break;
                case 'y':
                    note = 11;
                    break;
                case 'n':
                    this.octaveDown();
                    break;
                case 'm':
                    this.octaveUp();
                    break;
                case 'p':
                    keepPlaying = false;
                    System.out.println("You have stopped playing the " + manufacturer + " guitar.");
                    break;
                default:
                    System.out.println("Invalid input.");
            }
            System.out.print(playNoteAtOctave(note, thisOctave));
            System.out.print(" | ");
        }
    }

    @Override
    public void playCMajorScale() {
        System.out.println("You pick up your " + this.manufacturer + " guitar, with " + numFrets + " frets and...");
        if(isElectric == true){
            System.out.println("You proceed to plug it into the amplifier.");
        }
        System.out.println("You pluck out the C major scale: \n"
                + playNoteAtOctave(3,5) + " " + playNoteAtOctave(5,5) + " "
                + playNoteAtOctave(7,5) + " " + playNoteAtOctave(8,5) + " "
                + playNoteAtOctave(10,5) + " " + playNoteAtOctave(0,6) + " "
                + playNoteAtOctave(2,6) + " " + playNoteAtOctave(3,6) + ".");
    }

    @Override
    public void playCMajorChord() {
        System.out.println("You pick up your " + this.manufacturer + " guitar, with " + numFrets + " frets and...");
        if(isElectric == true){
            System.out.println("You proceed to plug it into the amplifier.");
        }
        System.out.println("You strum the C major chord: \n"
                + playNoteAtOctave(3,5) + " " + playNoteAtOctave(7,5) + " "
                + playNoteAtOctave(10,5));
    }

    @Override
    public void playLostWoodsIntro() {
        System.out.println("You pick up your " + this.manufacturer + " guitar, with " + numFrets + " frets and...");
        if(isElectric == true){
            System.out.println("You proceed to plug it into the amplifier.");
        }
        System.out.println("You begin to pick the Lost Woods Theme: \n"
                + playNoteAtOctave(8,5) + " " + playNoteAtOctave(0,6) + " "
                + playNoteAtOctave(2,6) + " " + playNoteAtOctave(8,5) + " "
                + playNoteAtOctave(0,6) + " " + playNoteAtOctave(2,6) + " "
                + playNoteAtOctave(8,5) + " " + playNoteAtOctave(0,6) + " "
                + playNoteAtOctave(2,6) + " " + playNoteAtOctave(7,6) + " "
                + playNoteAtOctave(5,6) + " " + playNoteAtOctave(2,6) + " "
                + playNoteAtOctave(3,6) + " " + playNoteAtOctave(2,6) + " "
                + playNoteAtOctave(10,5) + " " + playNoteAtOctave(7,5) + " "
                + playNoteAtOctave(5,5) + " " + playNoteAtOctave(7,5) + " "
                + playNoteAtOctave(10,5) + " " + playNoteAtOctave(7,5) + ".");
    }

    public Guitars(String manufacturer, boolean isElectric, int numFrets) {
        this.manufacturer = manufacturer;
        this.isElectric = isElectric;
        this.numFrets = numFrets;
    }
}

class Pianos extends Instruments implements PlayInstrument{

    String manufacturer;
    boolean isSynth;
    int numKeys;
    private int thisOctave = 0;

    public void octaveUp(){
        if(thisOctave < 8){
            thisOctave +=1;
        }else{
            System.out.println("You are already at the highest octave.");
        }
    }

    public void octaveDown(){
        if(thisOctave > 0){
            thisOctave -=1;
        }else{
            System.out.println("You are already at the lowest octave.");
        }
    }

    public void printInstructions(){
        System.out.println("You can play the piano by using the following keys for the following notes and actions: \n" +
                "a=A, w=A#, s=B, d=C, r=C#, f=D, u=D#, j=E, k=F, o=F#, l=G, p=G# \n" +
                "Press \"m\" to go up an octave and \"n\" to go down an octave | Press \"z\" to stop playing.");
    }

    public void takeUserInputAndPlay(){
        char noteChar;
        int note = 0;
        boolean keepPlaying = true;
        while(keepPlaying) {
            noteChar = userInput.next().charAt(0);
            switch (noteChar) {
                case 'a':
                    note = 0;
                    break;
                case 'w':
                    note = 1;
                    break;
                case 's':
                    note = 2;
                    break;
                case 'd':
                    note = 3;
                    break;
                case 'r':
                    note = 4;
                    break;
                case 'f':
                    note = 5;
                    break;
                case 'u':
                    note = 6;
                    break;
                case 'j':
                    note = 7;
                    break;
                case 'k':
                    note = 8;
                    break;
                case 'o':
                    note = 9;
                    break;
                case 'l':
                    note = 10;
                    break;
                case 'p':
                    note = 11;
                    break;
                case 'n':
                    this.octaveDown();
                    break;
                case 'm':
                    this.octaveUp();
                    break;
                case 'z':
                    keepPlaying = false;
                    System.out.println("You have stopped playing the " + manufacturer + " piano.");
                    break;
                default:
                    System.out.println("Invalid input.");
            }
            System.out.print(playNoteAtOctave(note, thisOctave));
            System.out.print(" | ");
        }
    }

    public void playEveryKey(){
        int counter = 0;
        for(int j = 0; j < getOctaves().length; j++){
            for(int i = 0; i < getNotes().length; i++){
                System.out.print(playNoteAtOctave(i,j));
                System.out.print("|");
                counter++;
                if(counter % 20 == 0){
                    System.out.println();
                }
                if(counter == numKeys){
                    return;
                }
            }
        }
    }

    @Override
    public void playCMajorScale() {
        System.out.println("You sit down at your " + this.manufacturer + " piano, with " + numKeys + " keys and...");
        if(isSynth == true){
            System.out.println("Because it is a synth, you first choose your favorite setting.");
        }
        System.out.println("Then, you gently play the C major scale: \n"
                + playNoteAtOctave(3,4) + " " + playNoteAtOctave(5,4) + " "
                + playNoteAtOctave(7,4) + " " + playNoteAtOctave(8,4) + " "
                + playNoteAtOctave(10,4) + " " + playNoteAtOctave(0,5) + " "
                + playNoteAtOctave(2,5) + " " + playNoteAtOctave(3,5) + ".");
    }

    @Override
    public void playCMajorChord() {
        System.out.println("You sit down at your " + this.manufacturer + " piano, with " + numKeys + " keys and...");
        if(isSynth == true){
            System.out.println("Because it is a synth, you first choose your favorite setting.");
            System.out.println("You strike the keys and play the C major chord: \n"
                    + playNoteAtOctave(3,4) + " " + playNoteAtOctave(7,4) + " "
                    + playNoteAtOctave(10,4));
        }

    }

    @Override
    public void playLostWoodsIntro() {
        System.out.println("You sit down at your " + this.manufacturer + " piano, with " + numKeys + " keys and...");
        if(isSynth == true){
            System.out.println("Because it is a synth, you first choose your favorite setting.");
            System.out.println("You begin to plunk along to the Lost Woods Theme on your keyboard: \n"
                    + playNoteAtOctave(8,4) + " " + playNoteAtOctave(0,5) + " "
                    + playNoteAtOctave(2,5) + " " + playNoteAtOctave(8,4) + " "
                    + playNoteAtOctave(0,5) + " " + playNoteAtOctave(2,5) + " "
                    + playNoteAtOctave(8,4) + " " + playNoteAtOctave(0,5) + " "
                    + playNoteAtOctave(2,5) + " " + playNoteAtOctave(7,5) + " "
                    + playNoteAtOctave(5,5) + " " + playNoteAtOctave(2,5) + " "
                    + playNoteAtOctave(3,5) + " " + playNoteAtOctave(2,5) + " "
                    + playNoteAtOctave(10,4) + " " + playNoteAtOctave(7,4) + " "
                    + playNoteAtOctave(5,4) + " " + playNoteAtOctave(7,4) + " "
                    + playNoteAtOctave(10,4) + " " + playNoteAtOctave(7,4) + ".");
        }

    }

    public Pianos(String manufacturer, boolean isSynth, int numKeys) {
        this.manufacturer = manufacturer;
        this.isSynth = isSynth;
        this.numKeys = numKeys;
    }
}