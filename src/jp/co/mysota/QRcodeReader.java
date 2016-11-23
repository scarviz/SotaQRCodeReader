package jp.co.mysota;

import java.awt.image.BufferedImage;
import jp.vstone.camera.CameraCapture;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class QRcodeReader {

	public String read(int retry) {
		String content = null;

		CameraCapture cap =null;
		cap = new CameraCapture(CameraCapture.CAP_IMAGE_SIZE_VGA,CameraCapture.CAP_FORMAT_BYTE_GRAY);
		try {
			cap.openDevice("/dev/video0");
		} catch (Exception e) {
			e.printStackTrace();
			return content;
		}

		for (int cnt = 0; cnt < retry; cnt++) {
			try{
					cap.snap();
				
					// 画像読み込み
					BufferedImage image = cap.RawtoBufferedImage();	    	
					LuminanceSource source = new BufferedImageLuminanceSource(image);
					BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
		
					// デコード
					Reader reader = new MultiFormatReader();
					Result result = reader.decode( bitmap );

					// バーコードコンテンツ（読み取り結果）
					content = result.getText();

					break;
			} catch(Exception e){
				e.printStackTrace();
			}
		}

		try{
        	cap.close();
		} catch(Exception e){
				e.printStackTrace();
		}

		System.out.println("content:" + content);
		return content;
	}
}