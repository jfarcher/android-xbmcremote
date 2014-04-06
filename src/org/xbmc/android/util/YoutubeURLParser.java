package org.xbmc.android.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.net.Uri;

 public static String parseYoutubeURL(Uri playuri) {
        Pattern patregex;
        
        if (playuri.getHost().endsWith("youtube.com") == true) {
            // We'll need to get the v= parameter from the URL and use
            // that to send to XBMC
            patregex = Pattern.compile("^http(:?s)?:\\/\\/(?:www\\.)?(?:youtube\\.com)\\/watch\\?(?=.*v=([\\w-]+))(?:\\S+)?$", Pattern.CASE_INSENSITIVE);
            
        } else if (playuri.getHost().endsWith("youtu.be") == true) {
            patregex = Pattern.compile("^http(:?s)?:\\/\\/(?:www\\.)?(?:youtu\\.be)(?=.*\\/([\\w-]+))(?:\\S+)?$", Pattern.CASE_INSENSITIVE);
                
        } else {
            patregex = null;
            return null;
        }

        final Pattern pattern = patregex;
        final Matcher matcher = pattern.matcher(playuri.toString());
        if (matcher.matches()) {
            return matcher.group(2);
        } else {
            return null;
        }
    }
