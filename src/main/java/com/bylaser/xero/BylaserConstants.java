/*
 *                     BylaserConstants.java
 * 
 *                   Created on 23/02/2010
 * 
 ***********************************************************************
 * The software source code or any other information contained in      *
 * this file is a property of Awaresoft Pty Ltd, ACN 099 495 468.      *
 *                                                                     * 
 * This information is proprietary and confidential. Any use of        *
 * this information or part thereof, including reading, analysis,      *
 * modification, copying, combining with other software, disclosure    *
 * or distribution in any form for any purpose, is strictly prohibited *
 * unless specifically authorised by Awaresoft Pty Ltd.                *
 *                                                                     *
 * If you received a copy of this file in error please destroy the     *
 * copy immediately and notify Awaresoft Pty Ltd.                      *
 *                                                                     *
 * Copyright (c) 2002 - 2005 Awaresoft Pty Ltd. All rights reserved.    *
 ***********************************************************************
 */
package com.bylaser.xero;

import com.bas.basserver.executionengine.IExecutionEngine;
import com.bas.basserver.executionengine.IProcess;
import com.bas.shared.data.QueryResult;
import com.bas.shared.domain.configuration.elements.Query;
import com.bas.shared.domain.operation.IEntity;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPInputStream;

/**
 * @author vlads
 *
 */
public class BylaserConstants 
{
	public static final String DATE_CREATED_ATTR =               "DateCreated";
	public static final String DATE_MODIFIED_ATTR =              "DateModified";
	public static final String MODIFIED_BY_ATTR =                "ModifiedBy";
	public static final String SYSTEM_SETTINGS_BASE_DIR_ATTR =   "BaseURLDirectory";
	public static final String SYSTEM_SETTINGS_BASE_URL_ATTR =   "BaseURL";
	public static final String SYSTEM_SETTINGS_BANK_DETAILS_ATTR ="BankDetails";
	public static final String SYSTEM_SETTINGS_INCOME_ACCOUNT_ATTR = "IncomeAccountName";
	public static final String SYSTEM_SETTINGS_PO_ACCOUNT_ATTR = "POAccountName";
	public static final String SYSTEM_SETTINGS_GST_RATE_ATTR   = "GSTRate";
	public static final String SYSTEM_SETTINGS_BYSOFT_MACHINE_CODE_ATTR = "BysoftMachineCode";
	public static final String SYSTEM_SETTINGS_AUTOCAD_USER_NAME_ATTR = "AutoCADUserName";
	public static final String SYSTEM_SETTINGS_AUTOCAD_PASSWORD_ATTR = "AutoCADPassword";
	public static final String SYSTEM_SETTINGS_AUTOCAD_TOKEN =   "AutoCADToken";
	public static final String SYSTEM_SETTINGS_PEP_EXPORT_DIR =  "PEPExportDirectory";
	public static final String SYSTEM_SETTINGS_PEP_IMPORT_DIR =  "PEPImportDirectory";
	public static final String SYSTEM_SETTINGS_QF_ATTR_SCRAP_BY = "QFAttributeScrapBy";
	public static final String SYSTEM_SETTINGS_QF_MIN_RESTOCK_DIM = "QFMinRestockDimension";
	public static final String SYSTEM_SETTINGS_QF_NEST_TOGETHER = "QFNestTogether";
	public static final String SYSTEM_SETTINGS_QF_OFFCUT_PREFERENCE = "QFOffcutPreference";
	public static final String SYSTEM_SETTINGS_QF_TIME_PER_NEST = "QFTimePerNestSeconds";
	public static final String SYSTEM_SETTINGS_QF_PART_PREVIEW_SIZE = "QFPartPreviewSize";
	public static final String SYSTEM_SETTINGS_QF_QUOTE_DELIVERY = "QFQuoteDeliveryTime";
	public static final String SYSTEM_SETTINGS_QF_URL =          "QFUrl";
	public static final String SYSTEM_SETTINGS_QF_LOCAL_URL =    "QFLocalUrl";
	public static final String SYSTEM_SETTINGS_LONG_JOB_PERC  =  "LongJobPercentage";
	public static final String SYSTEM_SETTINGS_MPS_NMB_USED_ATTR ="MPSNmbProcessesUsed";
	public static final String SYSTEM_SETTINGS_MPS_PROC1_ATTR =  "MPSProcess1";
	public static final String SYSTEM_SETTINGS_MPS_PROC2_ATTR =  "MPSProcess2";
	public static final String SYSTEM_SETTINGS_MPS_PROC3_ATTR =  "MPSProcess3";
	public static final String SYSTEM_SETTINGS_MPS_PROC4_ATTR =  "MPSProcess4";
	public static final String SYSTEM_SETTINGS_MPS_PROC5_ATTR =  "MPSProcess5";
	public static final String SYSTEM_SETTINGS_MPS_PROC6_ATTR =  "MPSProcess6";
	public static final String SYSTEM_SETTINGS_MPS_PROC7_ATTR =  "MPSProcess7";
	public static final String SYSTEM_SETTINGS_MPS_PROC8_ATTR =  "MPSProcess8";
	public static final String SYSTEM_SETTINGS_MPS_PROC9_ATTR =  "MPSProcess9";
	public static final String SYSTEM_SETTINGS_MPS_PROC10_ATTR = "MPSProcess10";
	public static final String SYSTEM_SETTINGS_XERO_CONSUMER_KEY_ATTR = "XeroConsumerKey";
	public static final String SYSTEM_SETTINGS_XERO_CONSUMER_SECRET_ATTR = "XeroConsumerSecret";
	public static final String SYSTEM_SETTINGS_XERO_REQ_TOKEN_SECRET_ATTR = "XeroReqTokenSecret";
	public static final String SYSTEM_SETTINGS_XERO_AUTH_URL_ATTR = "XeroAuthURL";
	public static final String SYSTEM_SETTINGS_XERO_ACC_TOKEN_SECRET_ATTR = "XeroAccessTokenSecret";
	public static final String SYSTEM_SETTINGS_XERO_ACC_TOKEN_ATTR = "XeroAccessToken";
	public static final String SYSTEM_SETTINGS_XERO_TOKENS_TIMESTAMP_ATTR = "XeroTokensTimestamp";
	public static final String SYSTEM_SETTINGS_SCHED_DISPLAY_ATTR = "SchedulerDisplay";
	public static final String SYSTEM_SETTINGS_SCHED_DISPLAY_JOBNO = "JOB NUMBER";
	public static final String SYSTEM_SETTINGS_SCHED_DISPLAY_PARTNO = "PART NUMBER";
	public static final String SYSTEM_SETTINGS_SCHED_DISPLAY_CUSTOMER_PARTNO = "CUSTOMER PART NUMBER";
	public static final String SYSTEM_SETTINGS_UNITS =           "UnitOfMeasure";
	public static final String SYSTEM_SETTINGS_COMPANY_NAME_ATTR = "CompanyName";
	public static final String SYSTEM_SETTINGS_VENDOR_SALES_ID_ATTR = "VendorSalesID";
	public static final String SYSTEM_SETTINGS_EMAIL_ATTR =      "EmailAddress";
	public static final String SYSTEM_SETTINGS_COUNTRY_ATTR =    "Country";
	public static final String SYSTEM_SETTINGS_ADDRESS1_ATTR =   "Address1";
	public static final String SYSTEM_SETTINGS_ADDRESS2_ATTR =   "Address2";
	public static final String SYSTEM_SETTINGS_PHONE_ATTR =      "Phone";
	public static final String SYSTEM_SETTINGS_LIGHT_VERSION_ATTR = "LightVersion";
	public static final String SYSTEM_SETTINGS_PRODUCT_NAME_ATTR = "ProductName";
	public static final String SYSTEM_SETTINGS_PRODUCT_CUTQUOTE  = "CutQuote";
	public static final String SYSTEM_SETTINGS_GANTT_SUPPORT  =  "GanttSupport";
	public static final String REGULAR_USER_NESTING_LICENSE_KEY ="NestingLicenseKey";
	public static final String CO_ENTITY =                       "CustomerOrder";
	public static final String CO_CUSTOMER_ATTR =                "Customer";
	public static final String CO_ORDER_NO_ATTR =                "OrderNo";
	public static final String CO_PARTS_ATTR =                   "Parts";
	public static final String CO_DISCOUNT_ATTR =                "Discount";
	public static final String CO_TOTAL_COST_PRODUCED_ATTR =     "TotalCostProduced";
	public static final String CO_TOTAL_COST_DELIVERED_ATTR =    "TotalCostDelivered2";
	public static final String CO_TOTAL_COST_ATTR =              "TotalCost";
	public static final String CO_RAISED_BY_ATTR =               "RaisedBy";
	public static final String CO_REQUIRED_BY_DATE_ATTR =        "RequiredByDate";
	public static final String CO_STATUS_ATTR =                  "Status";
	public static final String CO_STATUS_CANCELLED =             "CANCELLED";
	public static final String CO_STATUS_DELIVERED =             "DELIVERED";
	public static final String CO_STATUS_COMPLETE =              "COMPLETE";
	public static final String CO_STATUS_PARTIALLY_COMPLETE =    "PARTIALLY_COMPLETE";
	public static final String CO_STATUS_NEW =                   "NEW";
	public static final String CO_DELIVERY_COMPANY_ATTR =        "DeliveryCompany";
	public static final String CO_DELIVERY_ADDRESS_ATTR =        "DeliveryAddress";
	public static final String CO_DELIVERY_SUBURB_ATTR =         "DeliverySuburb";
	public static final String CO_DELIVERY_STATE_ATTR =          "DeliveryState";
	public static final String CO_DELIVERY_POSTCODE_ATTR =       "DeliveryPostcode";
	public static final String CO_DELIVERY_CONTACT_ATTR =        "DeliveryContact";
	public static final String CO_ATTACHMENTS_ATTR =             "Attachments";
	public static final String PARTIAL_DELIVERY_ENTITY =         "PartialDelivery";
	public static final String PD_TOTAL_COST_DELIVERED_ATTR =    "TotalCostDelivered";
	public static final String PD_STATUS_ATTR =                  "Status";
	public static final String PD_STATUS_NEW =                   "NEW";
	public static final String PD_LINE_ITEM_ENTITY =             "PDLineItem";
	public static final String PD_LINE_ITEM_PD_ATTR =            "PartialDelivery";
	public static final String PD_LINE_ITEM_CO_LINE_ITEM_ATTR =  "COLineItem";
	public static final String PD_LINE_ITEM_QTY_DELIVERED_ATTR = "QtyDelivered";
	public static final String PD_LINE_ITEM_TOTAL_COST_DELIVERED_ATTR = "TotalCostDelivered";
	public static final String INVOICE_ENTITY =                  "Invoice";
	public static final String INVOICE_EXPORT_ID_ATTR =          "ExportID";
	public static final String INVOICE_INVOICE_NO_ATTR =         "InvoiceNo";
	public static final String INVOICE_INVOICE_DATE_ATTR =       "InvoiceDate";
	public static final String INVOICE_XERO_STATUS_ATTR =        "XEROStatus";
	public static final String CUSTOMER_ENTITY =                 "Customer";
	public static final String CUSTOMER_ABN_ATTR =               "ABN";
	public static final String CUSTOMER_ACC_CONTACTNAME_ATTR =   "AccContactName";
	public static final String CUSTOMER_ACC_EMAIL_ATTR =         "AccEmail";
	public static final String CUSTOMER_ACC_NO_ATTR =            "AccNo";
	public static final String CUSTOMER_ACC_STATUS_ATTR =        "AccStatus";
	public static final String CUSTOMER_ACC_STATUS_COD =         "COD";
	public static final String CUSTOMER_ACC_STATUS_30EOM =       "30 EOM";
	public static final String CUSTOMER_COMPANY_NAME_ATTR =      "CompanyName";
	public static final String CUSTOMER_COUNTRY_ATTR =           "Country";
	public static final String CUSTOMER_POSTAL_ADDRESS_ATTR =    "PostalAddress";
	public static final String CUSTOMER_POSTAL_SUBURB_ATTR =     "PostalSuburb";
	public static final String CUSTOMER_STATE_ATTR =             "State";
	public static final String CUSTOMER_POSTCODE_ATTR =          "Postcode";
	public static final String CUSTOMER_DELIVERY_COMPANY_ATTR =  "DeliveryCompany";
	public static final String CUSTOMER_DELIVERY_ADDRESS_ATTR =  "DeliveryAddress";
	public static final String CUSTOMER_DELIVERY_SUBURB_ATTR =   "DeliverySuburb";
	public static final String CUSTOMER_DELIVERY_STATE_ATTR =    "DeliveryState";
	public static final String CUSTOMER_DELIVERY_POSTCODE_ATTR = "DeliveryPostcode";
	public static final String CUSTOMER_PHONE_ATTR =             "Phone";
	public static final String CUSTOMER_MOBILE_PHONE_ATTR =      "Mobile";
	public static final String CUSTOMER_FAX_ATTR =               "Fax";
	public static final String CUSTOMER_MAIN_CONTACT_ATTR =      "MainContact";
	public static final String CUSTOMER_CLASS_ATTR =             "CustomerClass";
	public static final String CUSTOMER_LEAD_TIME_ATTR =         "LeadTime";
	public static final String CO_LINE_ITEM_ENTITY =             "COLineItem";
	public static final String CO_LINE_ITEM_CO_ATTR =            "CustomerOrder";
	public static final String CO_LINE_ITEM_PART_ATTR =          "Part";
	public static final String CO_LINE_ITEM_QTY_ORDERED_ATTR =   "QtyOrdered";
	public static final String CO_LINE_ITEM_QTY_PRODUCED_ATTR =  "QtyProduced";
	public static final String CO_LINE_ITEM_QTY_DELIVERED_ATTR = "QtyDelivered2";
	public static final String CO_LINE_ITEM_UNIT_COST_ATTR =     "UnitCost";
	public static final String CO_LINE_ITEM_DETAILS_ATTR =       "Details";
	public static final String CO_LINE_ITEM_TOTAL_COST_PRODUCED_ATTR = "TotalCostProduced";
	public static final String CO_LINE_ITEM_WO_NUMBER =          "WONumber";
	public static final String CO_LINE_ITEM_IS_ASSEMBLY =        "IsAssembly";
	public static final String CO_LINE_ITEM_REQUIRED_BY_ATTR =   "RequiredBy";
	public static final String CO_LINE_ITEM_STATUS_ATTR =        "Status";
	public static final String CO_LINE_ITEM_STATUS_COMPLETE =    "COMPLETE";
	public static final String CO_LINE_ITEM_STATUS_PART_COMPLETE ="PARTIALLY_COMPLETE";
	public static final String JOB_ENTITY =                      "Job";
	public static final String JOB_ATTACHMENTS_ATTR =            "Attachments";
	public static final String JOB_CO_ATTR =                     "CustomerOrder";
	public static final String JOB_CUSTOMER_ATTR =               "Customer";
	public static final String JOB_ESTIMATED_NEST_TIME =         "EstimatedNestTime";
	public static final String JOB_GROSS_MARGIN_ATTR =           "GrossMargin";
	public static final String JOB_MATERIAL_SUPPLIED_ATTR =      "MaterialSuppliedBy";
	public static final String JOB_MATERIAL_SUPPLIED_OUR_COMPANY = "Our Company";
	public static final String JOB_MATERIAL_SUPPLIED_CUSTOMER =  "Customer";
	public static final String JOB_MATERIAL_ATTR =               "Material";
	public static final String JOB_MATERIAL_BUY_COST_ATTR =      "MaterialBuyCost";
	public static final String JOB_NEST_NO_ATTR =                "NestNo";
	public static final String JOB_PART_NO_SC_ATTR =             "PartNoSC";
	public static final String JOB_QTY_ORDERED_ATTR =            "QtyOrdered";
	public static final String JOB_QTY_DELIVERED_ATTR =          "QtyDelivered";
	public static final String JOB_STATUS_ATTR =                 "Status";
	public static final String JOB_PART_ATTR =                   "Part";
	public static final String JOB_TYPE_ATTR =                   "Type";
	public static final String JOB_TYPE_PROFILE_CUTTING =        "Profile Cutting";	
	public static final String JOB_NO_ATTR =                     "JobNo";
	public static final String JOB_LINE_ITEM_ATTR =              "LineItem";
	public static final String JOB_ISLATE_ATTR =                 "IsLate";
	public static final String JOB_IS_NEST_MOTHER_ATTR =         "IsNestMother";
	public static final String JOB_DETAILS_ATTR =                "Details";
	public static final String JOB_DURATION_ATTR =               "EstimatedTotalJobTime";
	public static final String JOB_REAL_DURATION_ATTR =          "RealDuration";
	public static final String JOB_REAL_DURATION_MIN_ATTR =      "RealDurationMin";
	public static final String JOB_REAL_DURATION_MIN_USER_ATTR = "RealDurationMinUser";
	public static final String JOB_REQUIRED_BY_ATTR =            "RequiredBy";
	public static final String JOB_PROCESS_ATTR =                "ProcessName";
	public static final String JOB_LASER_WORK_ITEM_ATTR =        "LaserWorkItem";	
	public static final String JOB_MATERIAL_ALLOCATED_COST_ATTR = "MaterialAllocatedCost";
	public static final String JOB_FILE_NAME_ATTR =              "FileName";
	public static final String JOB_OFFCUTS_EXPECTED_ATTR =       "OffcutsExpected";
	public static final String JOB_INVENTORY_ALLOCATIONS_ATTR =  "InventoryAllocations";
	public static final String JOB_PROGRAMMER_ATTR =             "Programmer";	
	public static final String JOB_PROGRAMMER_NOTES_ATTR =       "ProgrammerNotes";	
	public static final String JOB_PROGRAMMING_STARTED_AT_ATTR = "ProgrammingStartedAt";	
	public static final String JOB_PROGRAMMING_FINISHED_AT_ATTR ="ProgrammingFinishedAt";	
	public static final String JOB_PROGRAMMING_HISTORY_ATTR =    "ProgrammingHistory";	
	public static final String JOB_IS_LASER_ATTR =               "IsLaser";	
	public static final String JOB_SECONDARY_PROCESS_ATTR =      "SecondaryProcessWorkItem";	
	public static final String JOB_BOM_PROCESS_ATTR =            "BOMWorkItem";	
	public static final String JOB_SCHEDULE_START_ATTR =         "ScheduleStart";	
	public static final String JOB_PREFERRED_MACHINE_ATTR =      "PreferredMachine";	
	public static final String JOB_SEQ_NO_ATTR =                 "SeqNo";	
	public static final String JOB_SUBCONTRACTOR_ITEM_ATTR =     "SubcontractorWorkItem";	
	public static final String JOB_PURCHASE_ORDER_ATTR =         "PurchaseOrder";	
	public static final String JOB_STATUS_NEW =                  "NEW";
	public static final String JOB_STATUS_IN_PROGRESS =          "IN PROGRESS";
	public static final String JOB_STATUS_COMPLETED =            "COMPLETED";
	public static final String JOB_STATUS_CANCELLED =            "CANCELLED";
	public static final String JOB_STATUS_WM =                   "WAITING FOR MATERIAL";
	public static final String JOB_STATUS_PS =                   "PROGRAMMING STARTED";
	public static final String JOB_STATUS_RFP =                  "READY FOR PRODUCTION";
	public static final String JOB_STATUS_PRINTED =              "PRINTED";
	public static final String JOB_TOTAL_COST_ATTR =             "TotalCost";	
	public static final String JOBTIMESLOT_ENTITY =              "JobTimeslot";
	public static final String JOBTIMESLOT_MACHINE_ATTR =        "Machine";
	public static final String JOBTIMESLOT_OLD_MACHINE_ATTR =    "OldMachine";
	public static final String JOBTIMESLOT_JOB_ATTR =            "Job";
	public static final String JOBTIMESLOT_MACHINE_ORDER_ATTR =  "MachineOrderSC";
	public static final String JOBTIMESLOT_PRIORITY_ATTR =       "Priority";
	public static final String JOBTIMESLOT_PRIORITY_NORMAL =     "Normal";
	public static final String QUOTE_ENTITY =                    "Quote";
	public static final String QUOTE_NO_ATTR =                   "QuoteNo";
	public static final String QUOTE_GRAND_TOTAL_ATTR =          "GrandTotal";
	public static final String QUOTE_QUOTED_BY_ATTR =            "QuotedBy";
	public static final String QUOTE_STATUS_ATTR =               "Status";
	public static final String QUOTE_STATUS_WON =                "WON";
	public static final String QUOTE_STATUS_NOT_WON =            "NOT_WON";
	public static final String QUOTE_ACCEPTANCE_LOG_ATTR =       "AcceptanceLog";
	public static final String QUOTE_ATTACHMENTS_ZIP_ATTR =      "AttachmentsZip";
	public static final String QUOTE_NEEDS_ACCEPTANCE_ATTR =     "NeedsAcceptance";
	public static final String QUOTE_HAS_PROGRESS_ITEMS_ATTR =   "HasQFProgressItems";
	public static final String QUOTE_LINE_ITEMS_ATTR =           "LineItems";
	public static final String QUOTE_LINE_ITEM_ENTITY =          "QuoteLineItem";
	public static final String QUOTE_LINE_ITEM_QUOTE_ATTR =      "Quote";
	public static final String QUOTE_LINE_ITEM_CQRI_ATTR =       "CutQuoteRequestItem";
	public static final String QUOTE_LINE_ITEM_PART_ATTR =       "Part";
	public static final String QUOTE_PROGRESS_ITEMS_ATTR =       "QFProgressItems";
	public static final String STOCK_VALUE_RECORD_ENTITY =       "StockValueRecord";
	public static final String SVR_STOCK_VALUE_ATTR =            "StockValue";
	public static final String SVR_DATE_ATTR =                   "Date";
	public static final String PART_ENTITY =                     "Part";
	public static final String PART_ATTACHMENTS_ATTR =           "Attachments";
	public static final String PART_PART_NO_ATTR =               "PartNo";
	public static final String PART_PART_NO_INT_ATTR =           "PartNoInt";
	public static final String PART_DESCRIPTION_ATTR =           "Description";
	public static final String PART_PROGRESS_ITEMS_ATTR =        "QFProgressItems";
	public static final String PART_HAS_PROGRESS_ITEMS_ATTR =    "HasQFProgressItems";
	public static final String PART_APPROVED_ATTR =              "Approved";
	public static final String PART_WORK_ITEMS_ATTR =            "WorkItems";
	public static final String PART_ESTIMATED_TIME_ATTR =        "EstimatedTime";
	public static final String PART_ESTIMATED_UNIT_TIME_ATTR =   "EstimatedUnitTime";
	public static final String PART_LASER_ITEM_ATTR =            "LaserWorkItem";
	public static final String PART_SINGLE_WORK_ITEM_ATTR =      "SingleWorkItem";
	public static final String PART_FM_CUSTOMER_ATTR =           "FM_Customer";
	public static final String PART_QUANTITY_ATTR =              "Quantity";
	public static final String PART_GROSS_MARGIN_ATTR =          "GrossMargin";
	public static final String PART_MATERIAL_NAME_ATTR =         "MaterialName";
	public static final String PART_MATERIAL_CODE_ATTR =         "MaterialCode";
	public static final String PART_MATERIAL_FINISH_ATTR =       "MaterialFinish";
	public static final String PART_MATERIAL_GRADE_ATTR =        "MaterialGrade";
	public static final String PART_MATERIAL_THICKNESS_ATTR =    "MaterialThickness";
	public static final String PART_MATERIAL_BY_ATTR =           "MaterialBy";
	public static final String PART_TOTAL_COST_ATTR =            "TotalCost";
	public static final String PART_UNIT_COST_ATTR =             "UnitCost";
	public static final String PART_TYPE_ATTR =                  "Type";
	public static final String PART_CUSTOMER_PART_NO_ATTR =      "CustomerPartNo";
	public static final String PART_PRICE_SCALE_ITEMS_ATTR =     "PriceScaleItems";
	public static final String PART_COMPONENTS_ATTR =            "Components";
	public static final String PART_PEP_DRAWING_ATTR =           "PEPDrawingName";
	public static final String PART_PICTURE_ATTR =               "Picture";
	public static final String PART_IS_STRUCTURAL_ATTR =         "IsStructural";
	public static final String PART_STRUCTURAL_BOM_ITEMS_ATTR =  "StructuralBOMItems";
	public static final String PO_ENTITY =                       "PurchaseOrder";
	public static final String PO_SUPPLIER_ATTR =                "Supplier";
	public static final String PO_SUBCONTRACTOR_ATTR =           "Subcontractor";
	public static final String PO_DATE_SENT_ATTR =               "DateSent";
	public static final String PO_DATE_RECEIVED_ATTR =           "DateReceived";
	public static final String PO_TOTAL_PRICE_ATTR =             "TotalPrice";
	public static final String PO_PONUMBER_ATTR =                "PONumber";
	public static final String PO_EXPORT_ID_ATTR =               "ExportID";
	public static final String PO_ACCOUNT_ATTR =                 "Account";
	public static final String PO_RAISED_BY_ATTR =               "RaisedBy";
	public static final String PO_STATE_ATTR =                   "State";
	public static final String PO_STATE_FULLY_RECEIVED =         "FULLY RECEIVED";
	public static final String PO_STATE_PARTIALLY_RECEIVED =     "PARTIALLY RECEIVED";
	public static final String PO_STATE_NEW =                    "NEW";
	public static final String PO_STATE_SENT =                   "SENT";
	public static final String SUPPLIER_ENTITY =                 "Supplier";
	public static final String SUPPLIER_COMPANY_NAME_ATTR =      "CompanyName";
	public static final String SUPPLIER_POSTAL_ADDRESS_ATTR =    "PostalAddress";
	public static final String SUPPLIER_POSTAL_SUBURB_ATTR =     "PostalSuburb";
	public static final String SUPPLIER_STATE_ATTR =             "State";
	public static final String SUPPLIER_POSTCODE_ATTR =          "Postcode";
	public static final String SUPPLIER_MAIN_CONTACT_ATTR =      "MainContact";
	public static final String SUPPLIER_PHONE_ATTR =             "Phone";
	public static final String SUPPLIER_FAX_ATTR =               "Fax";
	public static final String SUPPLIER_EMAIL_ATTR =             "EmailAddress";
	public static final String SUPPLIER_ACC_STATUS_ATTR =        "AccStatus";
	public static final String SUPPLIER_ACC_PHONE_ATTR =         "AccPhone";
	public static final String SUPPLIER_CLASS_ATTR =             "CustomerClass";
	public static final String SUPPLIER_COUNTRY_ATTR =           "Country";
	public static final String SUPPLIER_DELIVERY_ADDRESS_ATTR =  "DeliveryAddress";
	public static final String SUPPLIER_DELIVERY_SUBURB_ATTR =   "DeliverySuburb";
	public static final String SUPPLIER_DELIVERY_POSTCODE_ATTR = "DeliveryPostcode";
	public static final String SUPPLIER_DELIVERY_STATE_ATTR =    "DeliveryState";
	public static final String SUPPLIER_SALES_TAXNO_ATTR =       "SalesTaxNo";
	public static final String SUBCONTRACTOR_ENTITY =            "Subcontractor";
	public static final String SUBCONTRACTOR_COMPANY_NAME_ATTR = "CompanyName";
	public static final String SUBCONTRACTOR_POSTAL_ADDRESS_ATTR = "PostalAddress";
	public static final String SUBCONTRACTOR_POSTAL_SUBURB_ATTR = "PostalSuburb";
	public static final String SUBCONTRACTOR_STATE_ATTR =         "State";
	public static final String SUBCONTRACTOR_POSTCODE_ATTR =      "Postcode";
	public static final String SUBCONTRACTOR_CONTACT_PERSON_ATTR ="ContactPerson";
	public static final String SUBCONTRACTOR_CONTACT_PHONE_ATTR = "ContactPhone";
	public static final String SUBCONTRACTOR_EMAIL_ATTR =         "EmailAddress";
	public static final String SUBCONTRACTOR_ACC_STATUS_ATTR =    "AccStatus";
	public static final String SUBCONTRACTOR_SALES_TAXNO_ATTR =   "SalesTaxNo";
	public static final String SUBCONTRACTOR_CLASS_ATTR =         "CustomerClass";
	public static final String PO_LINE_ITEM_ENTITY =              "POLineItem";
	public static final String PO_LINE_ITEM_PURCHASE_ORDER_ATTR = "PurchaseOrder";
	public static final String PO_LINE_ITEM_TOTAL_PRICE_ATTR =    "TotalPrice";
	public static final String PO_LINE_ITEM_UNIT_PRICE_ATTR =     "UnitPrice";
	public static final String PO_LINE_ITEM_DESCR_ATTR =          "Description";
	public static final String PO_LINE_ITEM_QTY_ORDERED_ATTR =    "QtyOrdered";
	public static final String PO_LINE_ITEM_QTY_RECEIVED_ATTR =   "QtyReceived";
	public static final String PO_LINE_ITEM_PRODUCT_ATTR =        "Product";
	public static final String EXPORT_RESULTS_ENTITY =            "ExportResults";
	public static final String EXPORT_RESULTS_EXPORT_ID_ATTR =    "ExportID";
	public static final String EXPORT_RESULTS_FILE_PATHS_ATTR =   "FilePaths";
	public static final String EXPORT_RESULTS_MERGED_FILE_PATH_ATTR = "MergedFilePath";
	public static final String EXPORT_RESULTS_IS_PO_ATTR =         "IsPurchaseOrder";
	public static final String EXPORT_RESULTS_DOC_ATTR =          "ExportDoc";
	public static final String EXPORT_RESULTS_EXPORT_MSG_ATTR =   "ExportMsg";
	public static final String EXPORT_RESULTS_EXPORT_OBJ_ATTR =   "ExportObject";
	public static final String CUSTOMER_CLASS_NAME_ATTR =         "Name";
	public static final String PRODUCT_ENTITY =                   "Product";
	public static final String PRODUCT_MATERIAL_ATTR =            "Material";
	public static final String PRODUCT_PRICE_ATTR =               "Price";
	public static final String PRODUCT_PRICE_PER_LENGTH_UNIT_ATTR ="PricePerLengthUnit";
	public static final String PRODUCT_SHEET_LENGTH_ATTR =        "SheetLength";
	public static final String PRODUCT_SHEET_WIDTH_ATTR =         "SheetWidth";
	public static final String PRODUCT_SUPPLIER_ATTR =            "Supplier";
	public static final String PRODUCT_SUPPLIER_NAME_ATTR =       "SupplierNameSC";
	public static final String PRODUCT_COST_CODE_ATTR =           "CostCode";
	public static final String PRODUCT_AVAILABLE_FOR_NESTING_ATTR = "AvailableForNesting";
	public static final String PRODUCT_PRICE_MATRIX_ATTR =        "PriceMatrix";
	public static final String PRODUCT_PRICE_ITEM_ENTITY =        "ProductPriceItem";
	public static final String PRODUCT_PRICE_ITEM_MIN_QTY_ATTR =  "MinQty";
	public static final String PRODUCT_PRICE_ITEM_MAX_QTY_ATTR =  "MaxQty";
	public static final String PRODUCT_PRICE_ITEM_UNIT_PRICE_ATTR ="UnitPrice";
	public static final String PRODUCT_STATUS_ATTR =              "Status";
	public static final String PRODUCT_STATUS_ACTIVE =            "ACTIVE";
	public static final String MATERIAL_ENTITY =                  "Material";
	public static final String MATERIAL_CODE_ATTR =               "Code";
	public static final String MATERIAL_NAME_ATTR =               "Name";
	public static final String MATERIAL_GRADE_ATTR =              "Grade";
	public static final String MATERIAL_FINISH_ATTR =             "Finish";
	public static final String MATERIAL_THICKNESS_ATTR =          "Thickness";
	public static final String MATERIAL_BYSOFT_CODE_ATTR =        "BysoftCode";
	public static final String MATERIAL_PEP_CODE_ATTR =           "PEPCode";
	public static final String LASER_WORK_ITEM_ENTITY =           "LaserProcessWorkItem";
	public static final String LASER_WORK_ITEM_PRODUCT_ATTR =     "MaterialToBuy";
	public static final String LASER_WORK_ITEM_SPEED1_ATTR =      "Speed1";
	public static final String LASER_WORK_ITEM_SPEED2_ATTR =      "Speed2";
	public static final String LASER_WORK_ITEM_SPEED3_ATTR =      "Speed3";
	public static final String LASER_WORK_ITEM_MAX_SPEED_ATTR =   "MaxSpeed";
	public static final String LASER_WORK_ITEM_PIERCE_TIME_ATTR = "PierceTime";
	public static final String LASER_WORK_ITEM_GROSS_MARGIN_ATTR = "GrossMargin";
	public static final String LASER_WORK_ITEM_SUPPLIER_CONTACT_ATTR = "FM_SupplierContact";
	public static final String LASER_WORK_ITEM_MATERIAL_BY_ATTR = "MaterialSuppliedBy";
	public static final String LASER_WORK_ITEM_TOTAL_FIXED_ATTR = "TotalFixedCosts";
	public static final String LASER_WORK_ITEM_TOTAL_UNIT_CUT_TIME_ATTR = "TotalUnitCutTime";
	public static final String LASER_WORK_ITEM_UNIT_CUT_COST_ATTR = "UnitCutCost";
	public static final String LASER_WORK_ITEM_MATERIAL_SELL_PRICE_ATTR = "MaterialSellPrice";
	public static final String LASER_WORK_ITEM_UNIT_MATERIAL_SELL_PRICE_ATTR = "UnitMaterialSellPrice";
	public static final String LASER_WORK_ITEM_DELTA_PRICE_ADJ_ATTR = "DeltaPriceAdjustment";
	public static final String LASER_WORK_ITEM_COST_PER_SHEET_ATTR = "CostPerSheet";
	public static final String LASER_WORK_ITEM_PEP_DRAWING_ATTR = "PEPDrawingName";
	public static final String LASER_WORK_ITEM_PEP_NEST_ATTR =    "PEPNestName";
	public static final String LASER_WORK_ITEM_ATTACHMENTS_ATTR = "Attachments";
	public static final String LASER_WORK_ITEM_MATERIAL_UNIT_BUY_COST_ATTR = "MaterialUnitBuyCost";
	public static final String LASER_WORK_ITEM_PART_WIDTH_ATTR =  "PartWidth";
	public static final String LASER_WORK_ITEM_PART_LENGTH_ATTR = "PartLength";
	public static final String LASER_WORK_ITEM_NETPROFIT_MSG_ATTR = "NetProfitMsg";
	public static final String LASER_WORK_ITEM_NMB_HEADS_ATTR =   "NmbOfHeads";
	public static final String LASER_WORK_ITEM_LOAD_UNLOAD_TIME_ATTR = "LoadUnloadTime";
	public static final String LASER_WORK_ITEM_SETUP_TIME_ATTR =  "SetupTimeMin";
	public static final String WORK_ITEM_GROUP =                  "WorkItem";
	public static final String WORK_ITEM_DETAILS_ATTR =           "Details";
	public static final String WORK_ITEM_FM_COMPANY_NAME_ATTR =   "FM_CompanyName";
	public static final String WORK_ITEM_FM_CONTACT_ATTR =        "FM_Contact";
	public static final String WORK_ITEM_FM_PHONE_ATTR =          "FM_Phone";
	public static final String WORK_ITEM_FM_SUPPLIER_ATTR =       "FM_SupplierName";
	public static final String WORK_ITEM_MATERIAL_ATTR =          "Material";
	public static final String WORK_ITEM_SHEET_LENGTH_ATTR =      "SheetLength";
	public static final String WORK_ITEM_SHEET_WIDTH_ATTR =       "SheetWidth";
	public static final String WORK_ITEM_PROCESS_ATTR =           "Process";
	public static final String WORK_ITEM_PART_ATTR =              "Part";
	public static final String WORK_ITEM_JOB_ATTR =               "Job";
	public static final String WORK_ITEM_INVENTORY_ITEM_ATTR =    "InventoryItem";
	public static final String WORK_ITEM_FM_PART_NO_ATTR =        "FM_PartNo";
	public static final String WORK_ITEM_IS_EXTERNAL_ATTR =       "IsExternal";
	public static final String WORK_ITEM_TYPE_ATTR =              "Type";
	public static final String WORK_ITEM_ESTIMATED_TIME_ATTR =    "EstimatedTotalJobTime";
	public static final String WORK_ITEM_PROCESS_NAME_ATTR =      "ProcessName";
	public static final String WORK_ITEM_QUANTITY_ATTR =          "Quantity";
	public static final String WORK_ITEM_TOTAL_COST_ATTR =        "TotalCost";
	public static final String WORK_ITEM_UNIT_COST_ATTR =         "UnitCost";
	public static final String WORK_ITEM_NET_PROFIT_ATTR =        "NetProfit";
	public static final String SECONDARY_WORK_ITEM_ENTITY =       "SecondaryProcessWorkItem";
	public static final String SEC_WORK_ITEM_PRODUCT_ATTR =       "MaterialToBuy";
	public static final String SEC_WORK_ITEM_SETUP_RATE_COST_ATTR ="SetupRateCost";
	public static final String SEC_WORK_ITEM_MATERIAL_TOTAL_COST_ATTR ="MaterialTotalCost";
	public static final String SEC_WORK_ITEM_MATERIAL_UNIT_COST_ATTR ="MaterialUnitCost";
	public static final String SEC_WORK_ITEM_UNIT_TIME_ATTR =     "UnitTime";
	public static final String SEC_WORK_ITEM_RECALC_MSG_ATTR =    "RecalcMsg";
	public static final String SEC_WORK_ITEM_NETPROFIT_MSG_ATTR = "NetProfitMsg";
	public static final String SUBC_WORK_ITEM_ENTITY =            "SubcontractorWorkItem";
	public static final String SUBC_WORK_ITEM_PROCESS_ATTR =      "WorkToDo";
	public static final String SUBC_WORK_ITEM_SPREAD_DELIVERY_ATTR = "SpreadDeliveryCost";
	public static final String SUBC_WORK_ITEM_RAW_COST_ATTR =     "RawCost";
	public static final String SUBC_WORK_ITEM_TOTAL_COST_ATTR =   "TotalCost";
	public static final String SUBC_WORK_ITEM_FTC_ATTR =          "ForwardTransportCosts";
	public static final String SUBC_WORK_ITEM_RTC_ATTR =          "ReturnTransportCosts";
	public static final String SUBC_WORK_ITEM_FLAT_PRICE_ATTR =   "FlatPrice";
	public static final String SUBC_WORK_ITEM_LEAD_TIME_ATTR =    "LeadTime";
	public static final String SUBC_WORK_ITEM_SUBCONTRACTOR_ATTR ="Subcontractor";
	public static final String SUBC_WORK_ITEM_WEEKENDS_ATTR =     "IncludeWeekends";
	public static final String BOM_WORK_ITEM_ENTITY =             "BOMWorkItem";
	public static final String BOM_WORK_ITEM_PRICING_METHOD_ATTR ="PricingMethod";
	public static final String BOM_WORK_ITEM_PRICING_METHOD_PER_UNIT = "Per Unit of Length";
	public static final String BOM_WORK_ITEM_PRODUCT_ATTR =       "Product";
	public static final String BOM_WORK_ITEM_UNIT_COST_ATTR =     "UnitCost";
	public static final String BOM_WORK_ITEM_MARGIN_ATTR =        "ProfitabilityMargin";
	public static final String MISC_WORK_ITEM_ENTITY =            "MiscWorkItem";
	public static final String INVENTORY_ITEM_ENTITY =            "InventoryItem";
	public static final String INV_ITEM_MATCODE_SC_ATTR =         "MaterialCodeSC";
	public static final String INV_ITEM_USED_BY_JOBS_ATTR =       "UsedByJobs";
	public static final String INV_ITEM_SPARE_PART_ATTR =         "SparePart";
	public static final String INV_ITEM_MATERIAL_ATTR =           "Material";
	public static final String INV_ITEM_QTY_AVAILABLE_ATTR =      "QtyAvailable";
	public static final String INV_ITEM_STOCK_VALUE_ATTR =        "StockValue";
	public static final String SPARE_PART_ENTITY =                "SparePart";
	public static final String SPARE_PART_PART_ATTR =             "Part";
	public static final String CUTSPEED_ENTITY =                  "Cutspeed";
	public static final String CUTSPEED_CODE_ATTR =               "Code";
	public static final String CUTSPEED_MAX_SPED_ATTR =           "MaximumSpeed";
	public static final String CUTSPEED_PIERCE_TIME_ATTR =        "PierceTime";
	public static final String CUTSPEED_SPEED1_ATTR =             "Speed1";
	public static final String CUTSPEED_SPEED2_ATTR =             "Speed2";
	public static final String CUTSPEED_SPEED3_ATTR =             "Speed3";
	public static final String CUTSPEED_SPACING_ATTR =            "Spacing";
	public static final String CUTSPEED_PROCESS_ATTR =            "Process";
	public static final String CUTSPEED_MATERIAL_ATTR =           "Material";
	public static final String CUTSPEED_MATERIAL_NAME_ATTR =      "MaterialName";
	public static final String CUTSPEED_MATERIAL_THICKNESS_ATTR = "MaterialThickness";
	public static final String CO_ATTACHMENT_ENTITY =             "COAttachment";
	public static final String CO_ATTACHMENT_CO_ATTR =            "CustomerOrder";
	public static final String CO_ATTACHMENT_SYSTEM_DOC_ATTR =    "SystemDocument";
	public static final String CO_ATTACHMENT_TREE_DOC_ATTR =      "TreeDocument";
	public static final String CO_ATTACHMENT_INV_ITEM_ATTR =      "InventoryItem";
	public static final String CO_ATTACHMENT_SOURCE_ATTR =        "Source";
	public static final String GRAPH_TIME_FILTER_START_DATE_ATTR ="StartDate";
	public static final String GRAPH_TIME_FILTER_END_DATE_ATTR =  "EndDate";
	public static final String GRAPH_TIME_FILTER_TYPE_ATTR =      "FilterType";
	public static final String GRAPH_TIME_FILTER_TYPE_TODAY =     "Today";
	public static final String GRAPH_TIME_FILTER_TYPE_THIS_WEEK = "This Week";
	public static final String GRAPH_TIME_FILTER_TYPE_THIS_MONTH ="This Month";
	public static final String GRAPH_TIME_FILTER_TYPE_THIS_QUATER = "This Quater";
	public static final String GRAPH_TIME_FILTER_TYPE_THIS_YEAR = "This Year";
	public static final String GRAPH_TIME_FILTER_TYPE_CUSTOM =    "Custom";
	public static final String GRAPH_TIME_FILTER_GRAPH_TYPE_ATTR ="GraphType";
	public static final String GRAPH_TIME_FILTER_RANGE_TYPE_ATTR ="RangeType";
	public static final String GRAPH_TIME_FILTER_RANGE_TYPE_DAY = "DAY";
	public static final String GRAPH_TIME_FILTER_RANGE_TYPE_WEEK ="WEEK";
	public static final String GRAPH_TIME_FILTER_RANGE_TYPE_MONTH ="MONTH";
	public static final String GRAPH_TIME_FILTER_RANGE_TYPE_QUATER ="QUATER";
	public static final String GRAPH_TIME_FILTER_RANGE_TYPE_YEAR = "YEAR";
	public static final String GRAPH_TIME_FILTER_GRAPH_TYPE_SALES ="SALES";
	public static final String GRAPH_TIME_FILTER_GRAPH_TYPE_TOP20 ="TOP 20";
	public static final String GRAPH_TIME_FILTER_GRAPH_TYPE_TOP_SUPPL ="TOP SUPPL";
	public static final String GRAPH_TIME_FILTER_GRAPH_TYPE_QUOTES ="QUOTES WON";
	public static final String GRAPH_TIME_FILTER_GRAPH_TYPE_MAT_SUPPLIED ="MATERIAL SUPPLIED";
	public static final String GRAPH_TIME_FILTER_GRAPH_TYPE_SUPPLIER ="SUPPLIER";
	public static final String STAT_RECORD_ENTITY =               "StatRecord";
	public static final String STAT_RECORD_START_DATE_ATTR =      "StartDate";
	public static final String STAT_RECORD_END_DATE_ATTR =        "EndDate";
	public static final String STAT_RECORD_RANGE_TYPE_ATTR =      "RangeType";
	public static final String STAT_RECORD_GRAPH_TYPE_ATTR =      "GraphType";
	public static final String STAT_RECORD_SALE_VALUE_ATTR =      "TotalSaleValue";
	public static final String STAT_RECORD_SALE_VALUE_PREV_ATTR = "TotalSaleValuePrev";
	public static final String STAT_RECORD_AVG_SALE_VALUE_ATTR =  "AvgSaleValue";
	public static final String STAT_RECORD_JOB_MARGIN_ATTR =      "JobGrossMargin";
	public static final String STAT_RECORD_JOB_MARGIN_PREV_ATTR = "JobGrossMarginPrev";
	public static final String STAT_RECORD_STOCK_VALUE_ATTR =     "StockValue";
	public static final String STAT_RECORD_STOCK_VALUE_PREV_ATTR ="StockValuePrev";
	public static final String STAT_RECORD_TIME_CALCULATED_ATTR = "TimeCalculated";
	public static final String STAT_RECORD_ON_TIME_RATIO_ATTR =   "OnTimeRatio";
	public static final String STAT_RECORD_ON_TIME_RATIO_PREV_ATTR = "OnTimeRatioPrev";
	public static final String STAT_RECORD_QUOTE_NMB_ATTR =       "QuoteNmb";
	public static final String STAT_RECORD_X_LABEL_ATTR =         "XLabel";
	public static final String STAT_RECORD_FORECASTED_ATTR =      "Forecasted";
	public static final String STAT_TOP_RECORD_ENTITY =           "StatTopRecord";
	public static final String STAT_TOP_RECORD_START_DATE_ATTR =  "StartDate";
	public static final String STAT_TOP_RECORD_END_DATE_ATTR =    "EndDate";
	public static final String STAT_TOP_RECORD_RANGE_TYPE_ATTR =  "RangeType";
	public static final String STAT_TOP_RECORD_GRAPH_TYPE_ATTR =  "GraphType";
	public static final String STAT_TOP_RECORD_SALE_VALUE_ATTR =  "TotalSaleValue";
	public static final String STAT_TOP_RECORD_CUSTOMER_ATTR =    "Customer";
	public static final String STAT_TOP_RECORD_SUPPLIER_ATTR =    "Supplier";
	public static final String STAT_TOP_RECORD_TIME_CALCULATED_ATTR = "TimeCalculated";
	public static final String STAT_MAT_SUPPLIER_RECORD_ENTITY =  "StatMatSupplierRecord";
	public static final String STAT_MAT_SUPPLIER_RECORD_START_DATE_ATTR = "StartDate";
	public static final String STAT_MAT_SUPPLIER_RECORD_END_DATE_ATTR =    "EndDate";
	public static final String STAT_MAT_SUPPLIER_RECORD_RANGE_TYPE_ATTR =  "RangeType";
	public static final String STAT_MAT_SUPPLIER_RECORD_GRAPH_TYPE_ATTR =  "GraphType";
	public static final String STAT_MAT_SUPPLIER_RECORD_VALUE_ATTR =       "Value";
	public static final String STAT_MAT_SUPPLIER_RECORD_VALUE_PREV_ATTR =  "ValuePrev";
	public static final String STAT_MAT_SUPPLIER_MATERIAL_ATTR =  "Material";
	public static final String STAT_MAT_SUPPLIER_SUPPLIER_ATTR =  "Supplier";
	public static final String STAT_MAT_SUPPLIER_RECORD_TIME_CALCULATED_ATTR = "TimeCalculated";
	public static final String STAT_PIE_RECORD_ENTITY =           "StatPieRecord";
	public static final String STAT_PIE_RECORD_START_DATE_ATTR =  "StartDate";
	public static final String STAT_PIE_RECORD_END_DATE_ATTR =    "EndDate";
	public static final String STAT_PIE_RECORD_RANGE_TYPE_ATTR =  "RangeType";
	public static final String STAT_PIE_RECORD_VALUE_ATTR =       "Value";
	public static final String STAT_PIE_RECORD_X_LABEL_ATTR =     "XLabel";
	public static final String STAT_PIE_RECORD_GRAPH_TYPE_ATTR =  "GraphType";
	public static final String STAT_PIE_RECORD_TIME_CALCULATED_ATTR = "TimeCalculated";
	public static final String DSR_TOTAL_QUOTES_TODAY =           "TotalQuotesToday";
	public static final String DSR_TOTAL_QUOTES_TODAY_USER =      "TotalQuotesTodayUser";
	public static final String DSR_TOTAL_QUOTES_THIS_MONTH =      "TotalQuotesThisMonth";
	public static final String DSR_TOTAL_QUOTES_THIS_MONTH_USER = "TotalQuotesThisMonthUser";
	public static final String DSR_QUOTES_WON_THIS_MONTH_USER =   "QuotesWonPercThisMonthUser";
	public static final String DSR_QUOTES_WON_TODAY_USER =        "QuotesWonPercTodayUser";
	public static final String DSR_TOTAL_COST_CO_TODAY =          "TotalCostCOToday";
	public static final String DSR_TOTAL_COST_CO_TODAY_USER =     "TotalCostCOTodayUser";
	public static final String DSR_TOTAL_COST_CO_THIS_MONTH =     "TotalCostCOThisMonth";
	public static final String DSR_TOTAL_COST_CO_THIS_MONTH_USER ="TotalCostCOThisMonthUser";
	public static final String DSR_TOTAL_COST_CO_LAST_MONTH_INV_DATE ="TotalCostCOLastMonthInvDate";
	public static final String DSR_TOTAL_COST_CO_THIS_MONTH_INV_DATE ="TotalCostCOThisMonthInvDate";
	public static final String DSR_TOTAL_COST_CO_TODAY_INV_DATE ="TotalCostCOTodayInvDate";
	public static final String DSR_AVG_JOB_GM_TODAY =             "AvgJobGrossMarginToday";
	public static final String DSR_AVG_JOB_GM_TODAY_USER =        "AvgJobGrossMarginTodayUser";
	public static final String DSR_AVG_JOB_GM_THIS_MONTH =        "AvgJobGrossMarginThisMonth";
	public static final String DSR_AVG_JOB_GM_THIS_MONTH_USER =   "AvgJobGrossMarginThisMonthUser";
	public static final String DSR_TOTAL_COST_JOBS_INCOMPLETE =   "TotalCostOfIncompleteJobs";
	public static final String DSR_TOTAL_COST_JOBS_WAITING =      "TotalCostOfWaitingJobs";
	public static final String DSR_TOTAL_COST_JOBS_IN_PROGRESS =  "TotalCostOfJobsInProgress";
	public static final String DSR_COUNT_CO_COMPLETED =           "CountCOCompleted";
	public static final String DSR_COUNT_CO_READY =               "CountCOReadyForExport";
	public static final String DSR_COUNT_PD_READY =               "CountPDReadyForExport";
	public static final String DSR_COUNT_JOBS_NEW_LASER =         "CountNewLaserJobs";
	public static final String DSR_COUNT_JOBS_STARTED_LASER =     "CountStartedLaserJobs";
	public static final String DSR_COUNT_JOBS_STARTED_LASER_USER ="CountStartedLaserJobsUser";
	public static final String DSR_COUNT_PO_OVERDUE =             "CountOverdueOrders";
	public static final String DSR_TOTAL_COST_PO_TODAY =          "TotalCostPOToday";
	public static final String DSR_TOTAL_COST_PO_TODAY_USER =     "TotalCostPOTodayUser";
	public static final String DSR_TOTAL_COST_PO_THIS_MONTH =     "TotalCostPOThisMonth";
	public static final String DSR_TOTAL_COST_PO_THIS_MONTH_USER ="TotalCostPOThisMonthUser";
	public static final String DSR_TOTAL_COST_INVENTORY =         "TotalCostInventory";
	public static final String DSR_TOTAL_COST_INVENTORY_MATERIAL ="TotalCostInventoryMaterial";
	public static final String DSR_TOTAL_COST_INVENTORY_SPARE_PART ="TotalCostInventorySparePart";
	public static final String SALE_FORECAST_ENTITY =             "SaleForecast";
	public static final String SALE_FORECAST_VALUE_ATTR =         "Value";
	public static final String SALE_FORECAST_START_DATE_ATTR =    "StartDate";
	public static final String SALE_FORECAST_END_DATE_ATTR =      "EndDate";
	public static final String COMPONENT_PART_ITEM_ENTITY =       "ComponentPartItem";
	public static final String CPI_PARENT_PART_ATTR =             "ParentPart";
	public static final String CPI_PART_ATTR =                    "Part";
	public static final String CPI_QUANTITY_ATTR =                "Quantity";
	public static final String WORK_ITEM_SEQ_ITEM_ENTITY =        "WorkItemSeqItem";
	public static final String WORK_ITEM_SEQ_ITEM_PART_ATTR =     "Part";
	public static final String WORK_ITEM_SEQ_ITEM_WORK_ITEM_ATTR ="WorkItem";
	public static final String REPORT_JOB_CARD_CONSOLIDATEd =     "JobCardConsolidated";
	public static final String SYSTEM_DOCUMENT_ENTITY =           "SystemDocument";
	public static final String SYSTEM_DOCUMENT_DOC_ATTR =         "Document";
	public static final String SYSTEM_DOCUMENT_TYPE_ATTR =        "Type";
	public static final String SYSTEM_DOCUMENT_AUTOCAD_URL_ATTR = "AutoCADUrl";
	public static final String MACHINE_ENTITY =                   "Machine";
	public static final String MACHINE_TIMESLOT_ENTITY =          "MachineTimeslot";
	public static final String MACHTIMESLOT_MACHINE_ATTR =        "Machine";
	public static final String MACHINE_PROCESS_ATTR =             "ProcessNameSC";
	public static final String MACHINE_NAME_ATTR =                "Name";
	public static final String MACHINE_NEXT_AVAILABLE_ATTR =      "NextAvailableTimeslot";
	public static final String MACHINE_SEQ_ORDER_ATTR =           "SeqOrder";
	public static final String MPR_ENTITY =                       "MachineProductionRecord";
	public static final String MPR_STATUS_ATTR =                  "Status";
	public static final String MPR_DURATION_ATTR =                "Duration";
	public static final String MPR_JOB_ATTR =                     "Job";
	public static final String MPR_MACHINE_ATTR =                 "Machine";
	public static final String MPR_STATUS_CURRENT =               "CURRENT";
	public static final String MPR_STATUS_STOPPED =               "STOPPED";
	public static final String TREE_DOCUMENT_ENTITY =             "TreeDocument";
	public static final String TREE_DOCUMENT_DOC_ATTR =           "Document";
	public static final String TREE_DOCUMENT_AUTOCAD_URL_ATTR =   "AutoCADUrl";
	public static final String STOCKALLOCATION_ENTITY =           "StockAllocation";
	public static final String STOCKALLOCATION_STATE_ATTR =       "State";
	public static final String STOCKALLOCATION_JOB_ATTR =         "Job";
	public static final String STOCKALLOCATION_COST_ATTR =        "Cost";
	public static final String STOCKALLOCATION_STATE_CURRENT =    "CURRENT";
	public static final String STOCKALLOCATION_STATE_USED =       "USED";
	public static final String QUOTEFABREQUEST_ENTITY =           "QuoteFabRequest";
	public static final String QUOTEFABREQUEST_PART_ATTR =        "Part";	
	public static final String QUOTEFABREQUEST_PARTNOSC_ATTR =    "PartNoSC";	
	public static final String QUOTEFABREQUEST_MULTIPART_ITEMS_ATTR = "MultipartItems";	
	public static final String QUOTEFABREQUEST_REQUEST_COMPLETE_ATTR = "RequestComplete";
	public static final String QUOTEFABREQUEST_QF_ATTR_SCRAP_BY = "QFAttributeScrapBy";
	public static final String QUOTEFABREQUEST_QF_NEST_TOGETHER = "QFNestTogether";
	public static final String QUOTEFABREQUEST_QF_OFFCUT_PREFERENCE = "QFOffcutPreference";
	public static final String QUOTEFABREQUEST_QF_TIME_PER_NEST = "QFTimePerNestSeconds";
	public static final String QUOTEFABREQUEST_CLOUD_XML_ATTR =   "CloudXML";	
	public static final String QUOTEFABREQUEST_ERROR_MSG_ATTR =   "ErrorMsg";	
	public static final String QUOTEFABREQUEST_JOB_ID_ATTR =      "QFJobID";	
	public static final String QUOTEFABREQUEST_NESTING_ONLINE_ID_ATTR = "NestingOnlineID";	
	public static final String QUOTEFABREQUEST_STATUS_ATTR =      "Status";
	public static final String QUOTEFABREQUEST_STATUS_SUBMITTED =  "SUBMITTED";
	public static final String QUOTEFABREQUEST_STATUS_CANCELLED =  "CANCELLED";
	public static final String QUOTEFABREQUEST_STATUS_FAILED =     "FAILED";
	public static final String QFMULTIPARTITEM_ENTITY =           "QFMultipartItem";
	public static final String QFMULTIPARTITEM_QF_REQUEST_ATTR =  "QFRequest";	
	public static final String QFMULTIPARTITEM_FILE_NAME_ATTR =   "FileName";
	public static final String QFMULTIPARTITEM_DETAILS_ATTR =     "Details";
	public static final String QFMULTIPARTITEM_PROCES_ATTR =      "Process";
	public static final String QFMULTIPARTITEM_PART_ATTR =        "Part";
	public static final String QFMULTIPARTITEM_XDIM_ATTR =        "XDim";
	public static final String QFMULTIPARTITEM_YDIM_ATTR =        "YDim";
	public static final String QFMULTIPARTITEM_PICTURE_ATTR =     "Picture";
	public static final String QFMULTIPARTITEM_AREA_ATTR =        "Area";
	public static final String QFMULTIPARTITEM_MODEL_ATTR =       "Model";
	public static final String QFMULTIPARTITEM_QUANTITY_ATTR =    "Quantity";	
	public static final String QFMULTIPARTITEM_ROTATION_ATTR =    "AngleRotation";	
	public static final String QFMULTIPARTITEM_PRODUCT_ATTR =     "MaterialToBuy";	
	public static final String QFMULTIPARTITEM_PRODUCTS_ATTR =    "Products";	
	public static final String QFMULTIPARTITEM_SPACING_ATTR =     "SpaceBetweenParts";	
	public static final String QFMULTIPARTITEM_MATERIAL_ATTR =    "Material";	
	public static final String QFMULTIPARTITEM_NMB_SHEETS_ALLOWED_ATTR = "NoFullSheetsAllowed";	
	public static final String QFMULTIPARTITEM_NMB_PIERCES_ATTR = "NmbOfPierces";	
	public static final String QFMULTIPARTITEM_TOOLPATH1_ATTR =   "Toolpath1";	
	public static final String QFMULTIPARTITEM_TOOLPATH2_ATTR =   "Toolpath2";	
	public static final String QFMULTIPARTITEM_ATTACHMENTS_ATTR = "Attachments";	
	public static final String QFMULTIPARTITEM_MATERIAL_SUPPLIED_ATTR = "MaterialSuppliedBy";	
	public static final String QFPROGRESS_ITEM_ENTITY =           "QFProgressItem";
	public static final String QFPI_REQUEST_ID_ATTR =             "RequestID";
	public static final String QFPI_CQMODE_ATTR =                 "CQMode";
	public static final String QFPI_EFFICIENCY_ATTR =             "Efficiency";
	public static final String QFPI_ERROR_ATTR =                  "ErrorMsg";
	public static final String QFPI_MATERIAL_NAME_ATTR =          "MaterialName";
	public static final String QFPI_NMB_SHEETS_USED_ATTR =        "NmbOfSheetsUsed";
	public static final String QFPI_PARTS_NESTED_ATTR =           "PartsNested";
	public static final String QFPI_PREVIEW_ATTR =                "Preview";
	public static final String QFPI_SHEET_ITEMS_ATTR =            "SheetItems";
	public static final String QFPI_SHEET_WL_ATTR =               "SheetWidthAndLength";
	public static final String QFPI_THICKNESS_ATTR =              "Thickness";
	public static final String QFPROGRESS_PARAM_REQ_STATUS_ATTR = "RequestStatus";
	public static final String QFPROGRESS_PARAM_REQ_STATUS_SUCCESS = "SUCCESS";
	public static final String QFPROGRESS_PARAM_CACHE_ATTR =      "ProgressCache";
	public static final String QFSHEET_ITEM_ENTITY =              "QFSheetItem";
	public static final String QFSI_EFFICIENCY_ATTR =             "Efficiency";
	public static final String QFSI_PREVIEW_ATTR =                "Preview";
	public static final String QFSI_PROGRESS_ITEM_ATTR =          "QFProgressItem";
	public static final String CUTQUOTE_REQUEST_ENTITY =          "CutQuoteRequest";
	public static final String CQR_ERROR_MSG_ATTR =               "ErrorMsg";
	public static final String CQR_CLOUD_XML_ATTR =               "CloudXML";
	public static final String CQR_QUOTE_ATTR =                   "Quote";
	public static final String CQR_REQUESTOR_ATTR =               "Requestor";
	public static final String CQR_REQUESTOR_NAME_ATTR =          "RequestorName";
	public static final String CQR_CUSTOMER_CONTACT_ATTR =        "CustomerContact";
	public static final String CQR_CUSTOMER_REF_NO_ATTR =         "CustomerRefNo";
	public static final String CQR_ITEMS_ATTR =                   "Items";
	public static final String CQR_QUOTE_COMPLETE_ATTR =          "QuoteComplete";
	public static final String CQR_STATUS_ATTR =                  "Status";
	public static final String CQR_STATUS_SUBMITTED =             "SUBMITTED";
	public static final String CQR_STATUS_CANCELLED =             "CANCELLED";
	public static final String CQR_STATUS_FAILED =                "FAILED";
	public static final String CQR_ITEM_ENTITY =                  "CutQuoteRequestItem";
	public static final String CQR_ITEM_ORG_REQUEST_ATTR =        "OrgRequest";
	public static final String CQ_FILE_NAME_ATTR =                "FileName";
	public static final String CQ_XDIM_ATTR =                     "XDim";
	public static final String CQ_YDIM_ATTR =                     "YDim";
	public static final String CQ_PICTURE_ATTR =                  "Picture";
	public static final String CQ_MODEL_ATTR =                    "Model";
	public static final String CQ_QUANTITY_ATTR =                 "Quantity";
	public static final String CQ_GRAIN_ATTR =                    "Grain";
	public static final String CQ_MATERIAL_ATTR =                 "Material";
	public static final String CQ_ORG_REQUEST_ATTR =              "OrgRequest";
	public static final String CQ_PRODUCT_ATTR =                  "Product";	
	public static final String CQ_SPACING_ATTR =                  "SpaceBetweenParts";	
	public static final String CQ_NMB_SHEETS_ALLOWED_ATTR =       "NoFullSheetsAllowed";	
	public static final String CQ_NMB_PIERCES_ATTR =              "NmbOfPierces";	
	public static final String CQ_TOOLPATH1_ATTR =                "Toolpath1";	
	public static final String CQ_TOOLPATH2_ATTR =                "Toolpath2";	
	public static final String CQ_ATTACHMENTS_ATTR =              "Attachments";	
	public static final String CQ_PROCESS_ATTR =                  "Process";	
	public static final String CQ_REQUESTOR_ATTR =                "Requestor";	
	public static final String CQ_NESTING_ONLINE_ID_ATTR =        "NestingOnlineID";	
	public static final String CQ_MATERIAL_SUPPLIED_BY_ATTR =     "MaterialSuppliedBy";	
	public static final String CQ_QF_JOB_ID_ATTR =                "QFJobID";	
	public static final String PEP_PART_ENTITY =                  "PEPPart";	
	public static final String PEP_PART_NEST_NAME_ATTR =          "NestName";	
	public static final String PEP_PART_DRAWING_NAME_ATTR =       "DrawingName";	
	public static final String PEP_PART_REVISION_ATTR =           "Revision";	
	public static final String PEP_PART_QTY_ATTR =                "PartQty";	
	public static final String PEP_PART_MATERIAL_CODE_ATTR =      "MaterialCode";	
	public static final String PEP_PART_MATERIAL_GRADE_ATTR =     "MaterialGrade";	
	public static final String PEP_PART_MATERIAL_THICKNESS_ATTR = "MaterialThickness";	
	public static final String PEP_PART_MATERIAL_DESCR_ATTR =     "MaterialDescription";	
	public static final String PEP_PART_MATERIAL_WIDTH_ATTR =     "MaterialWidth";	
	public static final String PEP_PART_MATERIAL_LENGTH_ATTR =    "MaterialLength";	
	public static final String PEP_PART_SIZE_ATTR =               "PartSize";	
	public static final String PEP_PART_SHIPPING_WEIGHT_ATTR =    "ShippingWeight";	
	public static final String PEP_PART_SHIPPING_WEIGHT_NMB_ATTR = "ShippingWeightNmb";	
	public static final String PEP_PART_COSTED_WEIGHT_ATTR =      "CostedWeight";	
	public static final String PEP_PART_COSTED_WEIGHT_NMB_ATTR =  "CostedWeightNmb";	
	public static final String PEP_PART_SHEET_QTY_ATTR =          "SheetQty";	
	public static final String PEP_PART_CUT_TIME_ATTR =           "CutTime";	
	public static final String PEP_PART_CAD_FILE_ATTR =           "CADFile";	
	public static final String PEP_PART_ORDER_IN_NEST_ATTR =      "OrderInNest";	
	public static final String PEP_PART_PICTURE_ATTR =            "Picture";	
	public static final String NEST_MEMBER_PARAM_QTY_ATTR =       "QtyDelivered";
	public static final String NEST_MEMBER_PARAM_JOB_ATTR =       "Job";
	public static final String NEST_MEMBER_PARAM_DURATION_ATTR =  "RealDurationMin";
	public static final String PRODUCTION_PROCESS_ENTITY =        "ProductionProcess";	
	public static final String PRODUCTION_PROCESS_NAME_ATTR =     "Name";
	public static final String PRODUCTION_PROCESS_MPS_ORDER_ATTR = "MPSOrderNo";
	public static final String PRODUCTION_PROCESS_COST_PER_HOUR_ATTR = "CostPerHour";
	public static final String COLINEITEM_QTY_PARAM_QTY_ATTR =     "Quantity";
	public static final String COLINEITEM_QTY_PARAM_COLINEITEM_ATTR = "COLineItem";
	public static final String COLINEITEM_QTY_PARAM_UNIT_COST_ATTR = "UnitCost";
	public static final String PRICE_SCALE_ITEM_QUANTITY_ATTR =    "Quantity";
	public static final String PRICE_SCALE_ITEM_UNIT_COST_ATTR =   "UnitCost";
	public static final String PRICE_SCALE_ITEM_PART_ATTR =        "Part";
	public static final String PRICE_SCALE_ITEM_DELTA_PRICE_ADJ_ATTR = "DeltaPriceAdjustment";
	public static final String AUDIT_RECORD_ENTITY =               "AuditRecord";
	public static final String AUDIT_RECORD_DETAILS_ATTR =         "Details";
	public static final String CORRESPONDENT_XEROID_ATTR =         "XeroId";
	public static final String DOCUMENTS_ROOT_ENTITY =             "DocumentsRoot";
	public static final String REGULAR_USER_FIRST_NAME_ATTR =      "FirstName";
	public static final String REGULAR_USER_LAST_NAME_ATTR =       "LastName";
	public static final String REGULAR_USER_EMAIL_ATTR =           "EmailAddress";
	public static final String SALES_SYSTEM_CQ_ENTITY =            "SalesSystemCQ";
	public static final String SALES_SYSTEM_CQ_SERVICE_URL_ATTR =  "ServiceURL";
	public static final String SALES_SYSTEM_CQ_BASE_URL_ATTR =     "BaseURL";
	public static final String EMAIL_TEMPLATE_ENTITY =             "EmailTemplate";
	public static final String EMAIL_TEMPLATE_NAME_ATTR =          "Name";
	public static final String EMAIL_TEMPLATE_SUBJECT_ATTR =       "Subject";
	public static final String EMAIL_TEMPLATE_MESSAGE_ATTR =       "Message";
	
	public static final String GANTT_TASK_ENTITY =                 "GanttTask";
	public static final String GANTT_TASK_JOB_ATTR =               "Job";
	public static final String GANTT_TASK_PART_ATTR =              "Part";
	public static final String GANTT_TASK_CO_ATTR =                "CustomerOrder";
	public static final String GANTT_TASK_IS_ASSEMBLY_ATTR =       "IsAssembly";
	public static final String GANTT_TASK_COLOR_NMB_ATTR =         "ColorNmb";
	
	public static final String QF_CREATE_QUOTE_PROCESS =           "QFCreateQuote";
	public static final String QF_NEST_RESULTS_PROCESS =           "QFAutoNestHandleResult";
	public static final String QF_QUOTE_ERROR_PROCESS =            "QFQuoteError";
	public static final String INIT_CQ_PORTAL_PROCESS =            "InitCutQuotePortal";
	
	public static final String ACL_VENDOR_CQ =                     "VendorCQ";
	
	public static IEntity getSystemSettings (IProcess process, IExecutionEngine engine)
		throws Exception 
	{
		Query query = Query.createFromRuleLanguageString ("FIND ALL SystemSettings");
		QueryResult qr = engine.executeQuery (process, query, new Integer (1), new Integer (1));
		IEntity [] ents = qr.getEntities();
		if (ents == null || ents.length == 0)
			throw new Exception ("Unable to find System Settings object");
		
		return ents[0];
	}
	
	public static String getQFCloudServiceUrl (IEntity systemSettings)
	{
		String url = "http://nestingonline.azurewebsites.net/api/request";
		try
		{
			String ssUrl = (String) systemSettings.getAttributeValue(SYSTEM_SETTINGS_QF_URL);
			if (ssUrl != null && ssUrl.trim().length() > 0)
				url = ssUrl;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return url;
	}
		
	/** Convert the given string into a proper XML string by handle special characters inside the XML string */
	public static String toXMLString (String s)
	{
		// Copied from CC
		if(s == null || "".equals(s.trim()))
			//return "&#160;";
			return "";

		StringBuffer stringbuffer = new StringBuffer();
		int i = s.length();
		for(int j = 0; j < i;)
		{
			char c = s.charAt(j++);
			if(c == '\r')
			{
				if(j + 1 < i && s.charAt(j + 1) == '\n')
					j++;
				//stringbuffer.append("&lt;br&gt;");
			} 
			else if (c == '\f')
			{
				// ignore
				continue;
			}
			else if(c < HTMLCODE.length)
			{
				if(null == HTMLCODE[c])
					stringbuffer.append(c);
				else
					stringbuffer.append(HTMLCODE[c]);
			} 
			else
			{
				stringbuffer.append(c);
			}
		}

		return stringbuffer.toString();
	}
		
	public static String getAutoClosingHTML ()
	{
		StringBuffer buffer = new StringBuffer ();
		
		buffer.append ("<html> \r\n");
		buffer.append ("<body onload=\"document.getElementById ('close_button').click(); \" > \r\n");
		
		buffer.append ("<button id=\"close_button\" onclick=\"window.close();\" >Close</button>");
		
		buffer.append ("</body> \r\n");
		buffer.append ("</html> \r\n");
		
		return buffer.toString();
	}
	
	public static byte [] uncompressGZip (byte [] orgData)
		throws Exception
	{
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		GZIPInputStream in = null;
		try
		{
			in = new GZIPInputStream(new ByteArrayInputStream(orgData));
			
			byte [] buf = new byte [16000];
			
			int read;
			while ((read = in.read(buf)) != -1) 
			{
				out.write(buf, 0, read);
			}
		}
		finally
		{
			if (in != null)
				in.close();
			
			out.close();			
		}
		
		return out.toByteArray();
	}
	
	// Copied from CC
	private static final String HTMLCODE[] = {
		null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, "&quot;", null, null, null, "&amp;", null, 
		null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, 
		"&lt;", null, "&gt;", null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null,
		/* These cause EXT failure
		"&#160;", "&iexcl;", "&cent;", "&pound;", "&curren;", "&yen;", "&brvbar;", "&sect;", "&uml;", "&copy;", 
		"&ordf;", "&laquo;", "&not;", "&shy;", "&reg;", "&macr;", "&deg;", "&plusmn;", "&sup2;", "&sup3;", 
		"&acute;", "&micro;", "&para;", "&middot;", "&cedil;", "&sup1;", "&ordm;", "&raquo;", "&frac14;", "&frac12;", 
		"&frac34;", "&iquest;", "&Agrave;", "&Aacute;", "&Acirc;", "&Atilde;", "&Auml;", "&Aring;", "&AElig;", "&Ccedil;", 
		"&Egrave;", "&Eacute;", "&Ecirc;", "&Euml;", "&Igrave;", "&Iacute;", "&Icirc;", "&Iuml;", "&ETH;", "&Ntilde;", 
		"&Ograve;", "&Oacute;", "&Ocirc;", "&Otilde;", "&Ouml;", "&times;", "&Oslash;", "&Ugrave;", "&Uacute;", "&Ucirc;", 
		"&Uuml;", "&Yacute;", "&THORN;", "&szlig;", "&agrave;", "&aacute;", "&acirc;", "&atilde;", "&auml;", "&aring;", 
		"&aelig;", "&ccedil;", "&egrave;", "&eacute;", "&ecirc;", "&euml;", "&igrave;", "&iacute;", "&icirc;", "&iuml;", 
		"&eth;", "&ntilde;", "&ograve;", "&oacute;", "&ocirc;", "&otilde;", "&ouml;", "&divide;", "&oslash;", "&ugrave;", 
		"&uacute;", "&ucirc;", "&uuml;", "&yacute;", "&thorn;", "&yuml;"
		*/
		null, null, null, null, null, null, null, null, null, null,
		null, null, null, null, null, null, null, null, null, null,
		null, null, null, null, null, null, null, null, null, null,
		null, null, null, null, null, null, null, null, null, null,
		null, null, null, null, null, null, null, null, null, null,
		null, null, null, null, null, null, null, null, null, null,
		null, null, null, null, null, null, null, null, null, null,
		null, null, null, null, null, null, null, null, null, null,
		null, null, null, null, null, null, null, null, null, null,
		null, null, null, null, null, null, null, null, null, null
	};
}
