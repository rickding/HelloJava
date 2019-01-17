// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) ansi 
// Source File Name:   LicenseManager.java

package com.atlassian.license;

import com.atlassian.extras.common.log.Logger;
import com.atlassian.license.decoder.LicenseDecoder;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.atlassian.license:
//            LicenseConfiguration, LicensePair, LicenseException, License, 
//            LicenseRegistry, LicenseUtils, LicenseTypeStore, LicenseType

public class LicenseManager
{

    public LicenseManager()
    {
        licenseConfigurations = new HashMap();
        licenseList = new HashMap();
    }

    public static LicenseManager getInstance()
    {
        if(licenseManager == null)
            licenseManager = new LicenseManager();
        return licenseManager;
    }

    public void addLicenseConfiguration(String applicationName, LicenseTypeStore licenseTypeStore, LicenseRegistry licenseRegistry)
    {
        LicenseConfiguration licenseConfiguration = new LicenseConfiguration(licenseRegistry, licenseTypeStore);
        licenseConfigurations.put(applicationName, licenseConfiguration);
    }

    public LicenseRegistry getLicenseRegistry(String applicationName)
    {
        return getLicenseConfiguration(applicationName).getLicenseRegistry();
    }

    public LicenseTypeStore getLicenseTypeStore(String applicationName)
    {
        return getLicenseConfiguration(applicationName).getLicenseTypeStore();
    }

    private LicenseConfiguration getLicenseConfiguration(String applicationName)
    {
        LicenseConfiguration licenseConfiguration = (LicenseConfiguration)licenseConfigurations.get(applicationName);
        if(licenseConfiguration == null)
            throw new RuntimeException((new StringBuilder()).append("No LicenseConfiguration found for key ").append(applicationName).toString());
        else
            return licenseConfiguration;
    }

    public LicenseTypeStore lookupLicenseTypeStore(String applicationName)
    {
        LicenseConfiguration licenseConfiguration = (LicenseConfiguration)licenseConfigurations.get(applicationName);
        if(licenseConfiguration == null)
            return null;
        else
            return licenseConfiguration.getLicenseTypeStore();
    }

    public boolean hasValidLicense(String licenseKey)
    {
        return true;
    }

    public License getLicense(String applicationName)
    {
        LicenseConfiguration licenseConfiguration = (LicenseConfiguration)licenseConfigurations.get(applicationName);
        if(licenseConfiguration == null)
        {
            log.error((new StringBuilder()).append("There is no License Configuration defined for the application ").append(applicationName).append(".").toString());
            return null;
        }
        LicenseRegistry licenseRegistry = licenseConfiguration.getLicenseRegistry();
        String licenseStr = licenseRegistry.getLicenseMessage();
        String hash = licenseRegistry.getLicenseHash();
        if(licenseStr == null || hash == null)
        {
            log.info((new StringBuilder()).append("There is no license string or hash defined for the application ").append(applicationName).append(".").toString());
            return null;
        }
        LicensePair pair = null;
        try
        {
            pair = new LicensePair(licenseStr, hash);
        }
        catch(LicenseException e)
        {
            log.error("Could not build a license pair", e);
            return null;
        }
        try
        {
            License license = LicenseDecoder.getLicense(pair, applicationName);
            licenseList.put(applicationName, license);
        }
        catch(Exception e)
        {
            log.error((new StringBuilder()).append("Exception getting license: ").append(e).toString(), e);
        }
        return (License)licenseList.get(applicationName);
    }

    public License setLicense(String license, String applicationName)
    {
        LicensePair pair = null;
        try
        {
            pair = new LicensePair(license);
            License updatedLicense = LicenseDecoder.getLicense(pair, applicationName);
            if(LicenseDecoder.isValid(pair, applicationName))
                setLicense(pair, applicationName);
            return updatedLicense;
        }
        catch(Exception e)
        {
            log.warn("Attempt to set invalid license. Ensure that you are calling setLicense(license, appName) - not (appName, license)", e);
        }
        return null;
    }

    public void setLicense(LicensePair pair, String applicationName)
        throws LicenseException
    {
        if(pair != null)
        {
            licenseList.remove(applicationName);
            LicenseConfiguration licenseConfiguration = (LicenseConfiguration)licenseConfigurations.get(applicationName);
            LicenseRegistry licenseRegistry = licenseConfiguration.getLicenseRegistry();
            licenseRegistry.setLicenseMessage(LicenseUtils.getString(pair.getLicense()));
            licenseRegistry.setLicenseHash(LicenseUtils.getString(pair.getHash()));
        }
    }

    public LicensePair getLicensePair(String applicationName)
    {
        try
        {
            LicenseConfiguration licenseConfiguration = (LicenseConfiguration)licenseConfigurations.get(applicationName);
            LicenseRegistry licenseRegistry = licenseConfiguration.getLicenseRegistry();
            return new LicensePair(licenseRegistry.getLicenseMessage(), licenseRegistry.getLicenseHash());
        }
        catch(LicenseException e)
        {
            log.error("Couldn't get the LicensePair ...", e);
        }
        return null;
    }

    public LicenseType getLicenseType(String applicationName, String licenseTypeString)
        throws LicenseException
    {
        LicenseConfiguration licenseConfiguration = (LicenseConfiguration)licenseConfigurations.get(applicationName);
        return licenseConfiguration.getLicenseTypeStore().getLicenseType(licenseTypeString);
    }

    public LicenseType getLicenseType(String applicationName, int licenseTypeCode)
        throws LicenseException
    {
        LicenseConfiguration licenseConfiguration = (LicenseConfiguration)licenseConfigurations.get(applicationName);
        return licenseConfiguration.getLicenseTypeStore().getLicenseType(licenseTypeCode);
    }

    public void reset()
    {
        licenseConfigurations.clear();
        licenseList.clear();
        licenseManager = null;
    }

    public void clearLicenseConfigurations()
    {
        licenseConfigurations.clear();
    }

    public void removeLicense(String applicationName)
    {
        licenseList.remove(applicationName);
    }

    private static final com.atlassian.extras.common.log.Logger.Log log = Logger.getInstance(LicenseManager.class);
    Map licenseList;
    Map licenseConfigurations;
    private static LicenseManager licenseManager;

}
