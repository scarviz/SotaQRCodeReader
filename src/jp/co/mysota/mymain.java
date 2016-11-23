//このソースは、VstoneMagicによって自動生成されました。
//ソースの内容を書き換えた場合、VstoneMagicで開けなくなる場合があります。
package	jp.co.mysota;
import	main.main.GlobalVariable;
import	jp.vstone.RobotLib.*;
import	jp.vstone.sotatalk.*;
import	jp.vstone.sotatalk.SpeechRecog.*;

public class mymain
{

	public int qrReadRetryCnt;
	public mymain()																										//@<BlockInfo>jp.vstone.block.func.constructor,32,32,192,32,False,2,@</BlockInfo>
	{
																														//@<OutputChild>
		qrReadRetryCnt=30;																								//@<BlockInfo>jp.vstone.block.variable,112,32,112,32,False,1,break@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>
	}																													//@<EndOfBlock/>

	//@<Separate/>
	public String readQRCode()																							//@<BlockInfo>jp.vstone.block.func,32,256,352,256,False,6,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		String content=null;																							//@<BlockInfo>jp.vstone.block.variable,112,256,112,256,False,5,break@</BlockInfo>
																														//@<EndOfBlock/>
		QRcodeReader reader = new QRcodeReader();																		//@<BlockInfo>jp.vstone.block.freeproc,192,256,192,256,False,4,@</BlockInfo>
		content = reader.read(qrReadRetryCnt);
																														//@<EndOfBlock/>
		return content;																									//@<BlockInfo>jp.vstone.block.return,272,256,272,256,False,3,return@</BlockInfo>	@<EndOfBlock/>
																														//@</OutputChild>

	}																													//@<EndOfBlock/>

	//@<Separate/>
	public void main()																									//@<BlockInfo>jp.vstone.block.func,32,144,416,144,False,10,コメント@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		GlobalVariable.sotawish.Say((String)"20センチくらい離した位置で、QRコードを見せてね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,96,144,96,144,False,9,@</BlockInfo>
																														//@<EndOfBlock/>
		String content=null;																							//@<BlockInfo>jp.vstone.block.variable,176,144,176,144,False,8,break@</BlockInfo>
																														//@<EndOfBlock/>
		content=(String)readQRCode();																					//@<BlockInfo>jp.vstone.block.callfunc.base,256,144,256,144,False,7,@</BlockInfo>	@<EndOfBlock/>
		GlobalVariable.sotawish.Say((String)content,MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);			//@<BlockInfo>jp.vstone.block.talk.say,336,144,336,144,False,11,@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>

	}																													//@<EndOfBlock/>

}
