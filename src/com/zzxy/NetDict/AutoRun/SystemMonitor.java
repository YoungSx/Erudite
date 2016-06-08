package com.zzxy.NetDict.AutoRun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class SystemMonitor {
	private static final int CPUTIME = 500;  
    private static final int PERCENT = 100;  
    private static final int FAULTLENGTH = 10;
	
	/**
	 * 获取java虚拟机内存使用率
	 * @return double类型的使用率
	 */
	public static double getMemoryUsage()
	{

		int kb = 1024; 
		int mb = 1024 * kb;
	    // 可使用内存    
	    double totalMemory = Runtime.getRuntime().totalMemory() / mb;    
	    // 剩余内存    
	    double freeMemory = Runtime.getRuntime().freeMemory() / mb;    
	    // 最大可使用内存    
	    double maxMemory = Runtime.getRuntime().maxMemory() / mb; 
	    
	    return totalMemory/maxMemory;
	    
	}
  
    
	/**
	 * 获取系统版本
	 * @return
	 */
	public static String getOSName()
	{
		return System.getProperty("os.name");
	}
   
	
	/**
	 * 判断服务器当前是否忙碌
	 * @return true 为忙碌，false为空闲
	 */
	public static boolean isCpuANDMemoryBusy()
	{
		double cpuUsage = 0;
		boolean isBusy = false;
		String osName = getOSName();
		if(osName.equals("windows"))
		{
			cpuUsage = getWindowsCpuUsage();
		}
		else if(osName.equals("Linux"))
		{
			cpuUsage = getLinuxCpuUsage();
		}
		
		double memUsage = getMemoryUsage();
		
		if(cpuUsage < 0.7 && memUsage < 0.7)
		{
			isBusy = false;
		}else
		{
			isBusy = true;
		}
		return isBusy;
	}
    
    
    /**
     * Linux下获取cpu使用率
     * @return
     */
    public static double getLinuxCpuUsage(){  
        double cpuUsed = 0;  
        double idleUsed = 0.0;  
        double[] cpuarray = new double[2];  
        Runtime rt = Runtime.getRuntime();  
        Process p;  
        try {  
            p = rt.exec("top -b -n 1");  
            BufferedReader in = null;  
            in = new BufferedReader(new InputStreamReader(p.getInputStream()));  
            String str = null;  
            int linecount = 0;  
            while ((str = in.readLine()) != null) {  
                  linecount++;  
                  if (linecount == 3) {  
                   String[] s = str.split("%");  
                   String idlestr = s[3];  
                   String idlestr1[] = idlestr.split(" ");  
                   idleUsed = Double.parseDouble(idlestr1[idlestr1.length-1]);  
                   cpuUsed = 100-idleUsed;  
                   cpuarray[0]=cpuUsed;  
                   cpuarray[1]=idleUsed;  
                   break;  
                  }  
             }  
         } catch (IOException e) {  
             // TODO Auto-generated catch block  
             e.printStackTrace();  
         }catch (Exception e) {  
             // TODO: handle exception  
         }// call "top" command in linux   
               
        return cpuarray[0];  
              
     }   
    
    

    
    
	
    /**
     * 获取windows操作系统cpu使用率
     * @return
     */
    public static double getWindowsCpuUsage() {   
        try {   
            String procCmd = System.getenv("windir")   
                    + "\\system32\\wbem\\wmic.exe process get Caption,CommandLine,"  
                    + "KernelModeTime,ReadOperationCount,ThreadCount,UserModeTime,WriteOperationCount";   
            // 取进程信息   
            long[] c0 = readCpu(Runtime.getRuntime().exec(procCmd));   
            Thread.sleep(CPUTIME);   
            long[] c1 = readCpu(Runtime.getRuntime().exec(procCmd));   
            if (c0 != null && c1 != null) {   
                long idletime = c1[0] - c0[0];   
                long busytime = c1[1] - c0[1];   
                return Double.valueOf(   
                        PERCENT * (busytime) / (busytime + idletime))   
                        .doubleValue();   
            } else {   
                return 0.0;   
            }   
        } catch (Exception ex) {   
            ex.printStackTrace();   
            return 0.0;   
        }   
    }  
    
    
    private static long[] readCpu(final Process proc) {  
        long[] retn = new long[2];  
  
  
        try {  
            proc.getOutputStream().close();  
  
  
            InputStreamReader ir = new InputStreamReader(proc.getInputStream());  
            LineNumberReader input = new LineNumberReader(ir);  
            String line = input.readLine();  
  
  
            if ((line == null) || (line.length() < FAULTLENGTH)) {  
                return null;  
            }  
  
  
            int capidx = line.indexOf("Caption");  
            int cmdidx = line.indexOf("CommandLine");  
            int rocidx = line.indexOf("ReadOperationCount");  
            int umtidx = line.indexOf("UserModeTime");  
            int kmtidx = line.indexOf("KernelModeTime");  
            int wocidx = line.indexOf("WriteOperationCount");  
            long idletime = 0;  
            long kneltime = 0;  
            long usertime = 0;  
  
  
            while ((line = input.readLine()) != null) {  
                if (line.length() < wocidx) {  
                    continue;  
                }  
  
  
                // 字段出现顺序：Caption,CommandLine,KernelModeTime,ReadOperationCount,  
                // ThreadCount,UserModeTime,WriteOperation  
                String caption = substring(line, capidx, cmdidx - 1).trim();  
                String cmd = substring(line, cmdidx, kmtidx - 1).trim();  
  
  
                if (cmd.indexOf("wmic.exe") >= 0) {  
                    continue;  
                }  
  
  
                String s1 = substring(line, kmtidx, rocidx - 1).trim();  
                String s2 = substring(line, umtidx, wocidx - 1).trim();  
  
  
                if (caption.equals("System Idle Process")  
                        || caption.equals("System")) {  
                    if (s1.length() > 0) {  
                        idletime += Long.valueOf(s1).longValue();  
                    }  
  
  
                    if (s2.length() > 0) {  
                        idletime += Long.valueOf(s2).longValue();  
                    }  
  
  
                    continue;  
                }  
  
  
                if (s1.length() > 0) {  
                    kneltime += Long.valueOf(s1).longValue();  
                }  
  
  
                if (s2.length() > 0) {  
                    usertime += Long.valueOf(s2).longValue();  
                }  
            }  
  
  
            retn[0] = idletime;  
            retn[1] = kneltime + usertime;  
  
  
            return retn;  
        } catch (Exception ex) {  
            ex.printStackTrace();  
        } finally {  
            try {  
                proc.getInputStream().close();  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
  
  
        return null;  
    }  
    
    /** 
     * 由于String.subString对汉字处理存在问题（把一个汉字视为一个字节)，因此在 包含汉字的字符串时存在隐患，现调整如下： 
     *  
     * @param src 
     *            要截取的字符串 
     * @param start_idx 
     *            开始坐标（包括该坐标) 
     * @param end_idx 
     *            截止坐标（包括该坐标） 
     * @return 
     */  
    private static String substring(String src, int start_idx, int end_idx) {  
        byte[] b = src.getBytes();  
        String tgt = "";  
  
  
        for (int i = start_idx; i <= end_idx; i++) {  
            tgt += (char) b[i];  
        }  
  
  
        return tgt;  
    }  
	
	
}
