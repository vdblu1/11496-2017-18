package org.firstinspires.ftc.teamcode;
 import android.media.MediaPlayer;
 import com.qualcomm.robotcore.eventloop.opmode.OpMode;
 import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp(name = "MainDriving (Not for use)")
public class Main extends OpMode
{
    public void init()
    {
        MediaPlayer mediaPlayer = MediaPlayer.create(hardwareMap.appContext, R.raw.nxtstartupsound);
        mediaPlayer.start();
    }
    @Override
    public void loop() {
        ExtraMethods name = new ExtraMethods();
        name.Drive();
        name.FingerPosition();
    }
}



