/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javad;

import twitter4j.*;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Ari Adrian Ibrahim
 */

public class TwitterModel {

    private Twitter twitter;

    public TwitterModel() {
        twitter = new TwitterFactory().getInstance();
    }

    public void tweetStatus(String tweet) {
        try {
            twitter.updateStatus(tweet);
            JOptionPane.showMessageDialog(null, "Pesan Berhasil");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "judul exception",
                    "pesan exception", JOptionPane.ERROR_MESSAGE);
        }
    }

    public String getHomeTimeline() {
        String s = "";
        try {
            List<Status> status = twitter.getHomeTimeline();
            for (int i = 0; i < status.size(); i++) {
                s = s + status.get(i).getUser().getScreenName() + " - "
                        + status.get(i).getText() + "\n\n";
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "judul exception",
                    "pesan exception", JOptionPane.ERROR_MESSAGE);
        }
        return s;
    }
    public void followUser(String user){
        try {
            twitter.createFriendship(user);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "judul exception",
                    "pesan exception", JOptionPane.ERROR_MESSAGE);
        }
    }
}
