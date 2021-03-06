/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.socialcoding.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.liferay.socialcoding.model.JIRAIssue;
import com.liferay.socialcoding.model.JIRAIssueModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the JIRAIssue service. Represents a row in the &quot;jiraissue&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.socialcoding.model.JIRAIssueModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link JIRAIssueImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see JIRAIssueImpl
 * @see com.liferay.socialcoding.model.JIRAIssue
 * @see com.liferay.socialcoding.model.JIRAIssueModel
 * @generated
 */
public class JIRAIssueModelImpl extends BaseModelImpl<JIRAIssue>
	implements JIRAIssueModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a j i r a issue model instance should use the {@link com.liferay.socialcoding.model.JIRAIssue} interface instead.
	 */
	public static final String TABLE_NAME = "jiraissue";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", Types.BIGINT },
			{ "created", Types.TIMESTAMP },
			{ "updated", Types.TIMESTAMP },
			{ "project", Types.BIGINT },
			{ "pkey", Types.VARCHAR },
			{ "summary", Types.VARCHAR },
			{ "description", Types.VARCHAR },
			{ "reporter", Types.VARCHAR },
			{ "assignee", Types.VARCHAR },
			{ "resolution", Types.VARCHAR },
			{ "issuestatus", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table jiraissue (id LONG not null primary key,created DATE null,updated DATE null,project LONG,pkey VARCHAR(75) null,summary VARCHAR(75) null,description VARCHAR(75) null,reporter VARCHAR(75) null,assignee VARCHAR(75) null,resolution VARCHAR(75) null,issuestatus VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table jiraissue";
	public static final String ORDER_BY_JPQL = " ORDER BY jiraIssue.modifiedDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY jiraissue.updated DESC";
	public static final String DATA_SOURCE = "jiraDataSource";
	public static final String SESSION_FACTORY = "jiraSessionFactory";
	public static final String TX_MANAGER = "jiraTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.socialcoding.model.JIRAIssue"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.socialcoding.model.JIRAIssue"),
			false);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.socialcoding.model.JIRAIssue"),
			true);
	public static long ASSIGNEEJIRAUSERID_COLUMN_BITMASK = 1L;
	public static long KEY_COLUMN_BITMASK = 2L;
	public static long MODIFIEDDATE_COLUMN_BITMASK = 4L;
	public static long PROJECTID_COLUMN_BITMASK = 8L;
	public static long REPORTERJIRAUSERID_COLUMN_BITMASK = 16L;
	public static long STATUS_COLUMN_BITMASK = 32L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.socialcoding.model.JIRAIssue"));

	public JIRAIssueModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _jiraIssueId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setJiraIssueId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _jiraIssueId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return JIRAIssue.class;
	}

	@Override
	public String getModelClassName() {
		return JIRAIssue.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("jiraIssueId", getJiraIssueId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("projectId", getProjectId());
		attributes.put("key", getKey());
		attributes.put("summary", getSummary());
		attributes.put("description", getDescription());
		attributes.put("reporterJiraUserId", getReporterJiraUserId());
		attributes.put("assigneeJiraUserId", getAssigneeJiraUserId());
		attributes.put("resolution", getResolution());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long jiraIssueId = (Long)attributes.get("jiraIssueId");

		if (jiraIssueId != null) {
			setJiraIssueId(jiraIssueId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
		}

		String key = (String)attributes.get("key");

		if (key != null) {
			setKey(key);
		}

		String summary = (String)attributes.get("summary");

		if (summary != null) {
			setSummary(summary);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String reporterJiraUserId = (String)attributes.get("reporterJiraUserId");

		if (reporterJiraUserId != null) {
			setReporterJiraUserId(reporterJiraUserId);
		}

		String assigneeJiraUserId = (String)attributes.get("assigneeJiraUserId");

		if (assigneeJiraUserId != null) {
			setAssigneeJiraUserId(assigneeJiraUserId);
		}

		String resolution = (String)attributes.get("resolution");

		if (resolution != null) {
			setResolution(resolution);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public long getJiraIssueId() {
		return _jiraIssueId;
	}

	@Override
	public void setJiraIssueId(long jiraIssueId) {
		_jiraIssueId = jiraIssueId;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_columnBitmask = -1L;

		if (_originalModifiedDate == null) {
			_originalModifiedDate = _modifiedDate;
		}

		_modifiedDate = modifiedDate;
	}

	public Date getOriginalModifiedDate() {
		return _originalModifiedDate;
	}

	@Override
	public long getProjectId() {
		return _projectId;
	}

	@Override
	public void setProjectId(long projectId) {
		_columnBitmask |= PROJECTID_COLUMN_BITMASK;

		if (!_setOriginalProjectId) {
			_setOriginalProjectId = true;

			_originalProjectId = _projectId;
		}

		_projectId = projectId;
	}

	public long getOriginalProjectId() {
		return _originalProjectId;
	}

	@Override
	public String getKey() {
		if (_key == null) {
			return StringPool.BLANK;
		}
		else {
			return _key;
		}
	}

	@Override
	public void setKey(String key) {
		_columnBitmask |= KEY_COLUMN_BITMASK;

		if (_originalKey == null) {
			_originalKey = _key;
		}

		_key = key;
	}

	public String getOriginalKey() {
		return GetterUtil.getString(_originalKey);
	}

	@Override
	public String getSummary() {
		if (_summary == null) {
			return StringPool.BLANK;
		}
		else {
			return _summary;
		}
	}

	@Override
	public void setSummary(String summary) {
		_summary = summary;
	}

	@Override
	public String getDescription() {
		if (_description == null) {
			return StringPool.BLANK;
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		_description = description;
	}

	@Override
	public String getReporterJiraUserId() {
		if (_reporterJiraUserId == null) {
			return StringPool.BLANK;
		}
		else {
			return _reporterJiraUserId;
		}
	}

	@Override
	public void setReporterJiraUserId(String reporterJiraUserId) {
		_columnBitmask |= REPORTERJIRAUSERID_COLUMN_BITMASK;

		if (_originalReporterJiraUserId == null) {
			_originalReporterJiraUserId = _reporterJiraUserId;
		}

		_reporterJiraUserId = reporterJiraUserId;
	}

	public String getOriginalReporterJiraUserId() {
		return GetterUtil.getString(_originalReporterJiraUserId);
	}

	@Override
	public String getAssigneeJiraUserId() {
		if (_assigneeJiraUserId == null) {
			return StringPool.BLANK;
		}
		else {
			return _assigneeJiraUserId;
		}
	}

	@Override
	public void setAssigneeJiraUserId(String assigneeJiraUserId) {
		_columnBitmask |= ASSIGNEEJIRAUSERID_COLUMN_BITMASK;

		if (_originalAssigneeJiraUserId == null) {
			_originalAssigneeJiraUserId = _assigneeJiraUserId;
		}

		_assigneeJiraUserId = assigneeJiraUserId;
	}

	public String getOriginalAssigneeJiraUserId() {
		return GetterUtil.getString(_originalAssigneeJiraUserId);
	}

	@Override
	public String getResolution() {
		if (_resolution == null) {
			return StringPool.BLANK;
		}
		else {
			return _resolution;
		}
	}

	@Override
	public void setResolution(String resolution) {
		_resolution = resolution;
	}

	@Override
	public String getStatus() {
		if (_status == null) {
			return StringPool.BLANK;
		}
		else {
			return _status;
		}
	}

	@Override
	public void setStatus(String status) {
		_columnBitmask |= STATUS_COLUMN_BITMASK;

		if (_originalStatus == null) {
			_originalStatus = _status;
		}

		_status = status;
	}

	public String getOriginalStatus() {
		return GetterUtil.getString(_originalStatus);
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			JIRAIssue.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public JIRAIssue toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (JIRAIssue)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		JIRAIssueImpl jiraIssueImpl = new JIRAIssueImpl();

		jiraIssueImpl.setJiraIssueId(getJiraIssueId());
		jiraIssueImpl.setCreateDate(getCreateDate());
		jiraIssueImpl.setModifiedDate(getModifiedDate());
		jiraIssueImpl.setProjectId(getProjectId());
		jiraIssueImpl.setKey(getKey());
		jiraIssueImpl.setSummary(getSummary());
		jiraIssueImpl.setDescription(getDescription());
		jiraIssueImpl.setReporterJiraUserId(getReporterJiraUserId());
		jiraIssueImpl.setAssigneeJiraUserId(getAssigneeJiraUserId());
		jiraIssueImpl.setResolution(getResolution());
		jiraIssueImpl.setStatus(getStatus());

		jiraIssueImpl.resetOriginalValues();

		return jiraIssueImpl;
	}

	@Override
	public int compareTo(JIRAIssue jiraIssue) {
		int value = 0;

		value = DateUtil.compareTo(getModifiedDate(),
				jiraIssue.getModifiedDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof JIRAIssue)) {
			return false;
		}

		JIRAIssue jiraIssue = (JIRAIssue)obj;

		long primaryKey = jiraIssue.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		JIRAIssueModelImpl jiraIssueModelImpl = this;

		jiraIssueModelImpl._originalModifiedDate = jiraIssueModelImpl._modifiedDate;

		jiraIssueModelImpl._originalProjectId = jiraIssueModelImpl._projectId;

		jiraIssueModelImpl._setOriginalProjectId = false;

		jiraIssueModelImpl._originalKey = jiraIssueModelImpl._key;

		jiraIssueModelImpl._originalReporterJiraUserId = jiraIssueModelImpl._reporterJiraUserId;

		jiraIssueModelImpl._originalAssigneeJiraUserId = jiraIssueModelImpl._assigneeJiraUserId;

		jiraIssueModelImpl._originalStatus = jiraIssueModelImpl._status;

		jiraIssueModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<JIRAIssue> toCacheModel() {
		JIRAIssueCacheModel jiraIssueCacheModel = new JIRAIssueCacheModel();

		jiraIssueCacheModel.jiraIssueId = getJiraIssueId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			jiraIssueCacheModel.createDate = createDate.getTime();
		}
		else {
			jiraIssueCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			jiraIssueCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			jiraIssueCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		jiraIssueCacheModel.projectId = getProjectId();

		jiraIssueCacheModel.key = getKey();

		String key = jiraIssueCacheModel.key;

		if ((key != null) && (key.length() == 0)) {
			jiraIssueCacheModel.key = null;
		}

		jiraIssueCacheModel.summary = getSummary();

		String summary = jiraIssueCacheModel.summary;

		if ((summary != null) && (summary.length() == 0)) {
			jiraIssueCacheModel.summary = null;
		}

		jiraIssueCacheModel.description = getDescription();

		String description = jiraIssueCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			jiraIssueCacheModel.description = null;
		}

		jiraIssueCacheModel.reporterJiraUserId = getReporterJiraUserId();

		String reporterJiraUserId = jiraIssueCacheModel.reporterJiraUserId;

		if ((reporterJiraUserId != null) && (reporterJiraUserId.length() == 0)) {
			jiraIssueCacheModel.reporterJiraUserId = null;
		}

		jiraIssueCacheModel.assigneeJiraUserId = getAssigneeJiraUserId();

		String assigneeJiraUserId = jiraIssueCacheModel.assigneeJiraUserId;

		if ((assigneeJiraUserId != null) && (assigneeJiraUserId.length() == 0)) {
			jiraIssueCacheModel.assigneeJiraUserId = null;
		}

		jiraIssueCacheModel.resolution = getResolution();

		String resolution = jiraIssueCacheModel.resolution;

		if ((resolution != null) && (resolution.length() == 0)) {
			jiraIssueCacheModel.resolution = null;
		}

		jiraIssueCacheModel.status = getStatus();

		String status = jiraIssueCacheModel.status;

		if ((status != null) && (status.length() == 0)) {
			jiraIssueCacheModel.status = null;
		}

		return jiraIssueCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{jiraIssueId=");
		sb.append(getJiraIssueId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", projectId=");
		sb.append(getProjectId());
		sb.append(", key=");
		sb.append(getKey());
		sb.append(", summary=");
		sb.append(getSummary());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", reporterJiraUserId=");
		sb.append(getReporterJiraUserId());
		sb.append(", assigneeJiraUserId=");
		sb.append(getAssigneeJiraUserId());
		sb.append(", resolution=");
		sb.append(getResolution());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.liferay.socialcoding.model.JIRAIssue");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>jiraIssueId</column-name><column-value><![CDATA[");
		sb.append(getJiraIssueId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projectId</column-name><column-value><![CDATA[");
		sb.append(getProjectId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>key</column-name><column-value><![CDATA[");
		sb.append(getKey());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>summary</column-name><column-value><![CDATA[");
		sb.append(getSummary());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reporterJiraUserId</column-name><column-value><![CDATA[");
		sb.append(getReporterJiraUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>assigneeJiraUserId</column-name><column-value><![CDATA[");
		sb.append(getAssigneeJiraUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>resolution</column-name><column-value><![CDATA[");
		sb.append(getResolution());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = JIRAIssue.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			JIRAIssue.class
		};
	private long _jiraIssueId;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _originalModifiedDate;
	private long _projectId;
	private long _originalProjectId;
	private boolean _setOriginalProjectId;
	private String _key;
	private String _originalKey;
	private String _summary;
	private String _description;
	private String _reporterJiraUserId;
	private String _originalReporterJiraUserId;
	private String _assigneeJiraUserId;
	private String _originalAssigneeJiraUserId;
	private String _resolution;
	private String _status;
	private String _originalStatus;
	private long _columnBitmask;
	private JIRAIssue _escapedModel;
}