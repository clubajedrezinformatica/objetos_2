package ar.edu.unlp.info.oo2;

public class VideoStreamMedia implements Media {
    private VideoStream videoStream;
    
    public VideoStreamMedia(VideoStream videoStream){
        this.videoStream = videoStream;
    }
    @Override
    public String play(){
        return this.videoStream.reproduce();
    }   
}