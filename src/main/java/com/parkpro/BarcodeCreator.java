package com.parkpro;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeImageHandler;
import net.sourceforge.barbecue.output.OutputException;

/**
 *
 * @author khusyasy
 */
public class BarcodeCreator {
    public static String path = "barcode/";
    
    public static BufferedImage generateBarcodeImage(String barcodeText) {
        try {            
            Barcode barcode = BarcodeFactory.createCode39(barcodeText, false);
            Font BARCODE_TEXT_FONT = new Font("Monospaced", Font.PLAIN, 12);
            barcode.setFont(BARCODE_TEXT_FONT);
            
            BufferedImage image = BarcodeImageHandler.getImage(barcode);
            return image;
        } catch (BarcodeException ex) {
            Logger.getLogger(BarcodeCreator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (OutputException ex) {
            Logger.getLogger(BarcodeCreator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
