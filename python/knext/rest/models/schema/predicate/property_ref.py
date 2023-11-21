# coding: utf-8
# Copyright 2023 Ant Group CO., Ltd.
#
# Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
# in compliance with the License. You may obtain a copy of the License at
#
# http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software distributed under the License
# is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
# or implied.


"""
    knext

    No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)  # noqa: E501

    The version of the OpenAPI document: 1.0.0
    Generated by: https://openapi-generator.tech
"""


import pprint
import re  # noqa: F401

import six

from knext.rest.configuration import Configuration


class PropertyRef(object):
    """NOTE: This class is auto generated by OpenAPI Generator.
    Ref: https://openapi-generator.tech

    Do not edit the class manually.
    """

    """
    Attributes:
      openapi_types (dict): The key is attribute name
                            and the value is attribute type.
      attribute_map (dict): The key is attribute name
                            and the value is json key in definition.
    """
    openapi_types = {
        "subject_type_ref": "SpgTypeRef",
        "basic_info": "PropertyRefBasicInfo",
        "object_type_ref": "SpgTypeRef",
        "advanced_config": "PropertyAdvancedConfig",
        "ontology_enum": "str",
        "project_id": "int",
        "ontology_id": "OntologyId",
        "alter_operation": "str",
        "ext_info": "object",
    }

    attribute_map = {
        "subject_type_ref": "subjectTypeRef",
        "basic_info": "basicInfo",
        "object_type_ref": "objectTypeRef",
        "advanced_config": "advancedConfig",
        "ontology_enum": "ontologyEnum",
        "project_id": "projectId",
        "ontology_id": "ontologyId",
        "alter_operation": "alterOperation",
        "ext_info": "extInfo",
    }

    def __init__(
        self,
        subject_type_ref=None,
        basic_info=None,
        object_type_ref=None,
        advanced_config=None,
        ontology_enum=None,
        project_id=None,
        ontology_id=None,
        alter_operation=None,
        ext_info=None,
        local_vars_configuration=None,
    ):  # noqa: E501
        """PropertyRef - a model defined in OpenAPI"""  # noqa: E501
        if local_vars_configuration is None:
            local_vars_configuration = Configuration()
        self.local_vars_configuration = local_vars_configuration

        self._subject_type_ref = None
        self._basic_info = None
        self._object_type_ref = None
        self._advanced_config = None
        self._ontology_enum = None
        self._project_id = None
        self._ontology_id = None
        self._alter_operation = None
        self._ext_info = None
        self.discriminator = None

        if subject_type_ref is not None:
            self.subject_type_ref = subject_type_ref
        if basic_info is not None:
            self.basic_info = basic_info
        if object_type_ref is not None:
            self.object_type_ref = object_type_ref
        if advanced_config is not None:
            self.advanced_config = advanced_config
        if ontology_enum is not None:
            self.ontology_enum = ontology_enum
        if project_id is not None:
            self.project_id = project_id
        if ontology_id is not None:
            self.ontology_id = ontology_id
        if alter_operation is not None:
            self.alter_operation = alter_operation
        if ext_info is not None:
            self.ext_info = ext_info

    @property
    def subject_type_ref(self):
        """Gets the subject_type_ref of this PropertyRef.  # noqa: E501


        :return: The subject_type_ref of this PropertyRef.  # noqa: E501
        :rtype: SpgTypeRef
        """
        return self._subject_type_ref

    @subject_type_ref.setter
    def subject_type_ref(self, subject_type_ref):
        """Sets the subject_type_ref of this PropertyRef.


        :param subject_type_ref: The subject_type_ref of this PropertyRef.  # noqa: E501
        :type: SpgTypeRef
        """

        self._subject_type_ref = subject_type_ref

    @property
    def basic_info(self):
        """Gets the basic_info of this PropertyRef.  # noqa: E501


        :return: The basic_info of this PropertyRef.  # noqa: E501
        :rtype: PropertyRefBasicInfo
        """
        return self._basic_info

    @basic_info.setter
    def basic_info(self, basic_info):
        """Sets the basic_info of this PropertyRef.


        :param basic_info: The basic_info of this PropertyRef.  # noqa: E501
        :type: PropertyRefBasicInfo
        """

        self._basic_info = basic_info

    @property
    def object_type_ref(self):
        """Gets the object_type_ref of this PropertyRef.  # noqa: E501


        :return: The object_type_ref of this PropertyRef.  # noqa: E501
        :rtype: SpgTypeRef
        """
        return self._object_type_ref

    @object_type_ref.setter
    def object_type_ref(self, object_type_ref):
        """Sets the object_type_ref of this PropertyRef.


        :param object_type_ref: The object_type_ref of this PropertyRef.  # noqa: E501
        :type: SpgTypeRef
        """

        self._object_type_ref = object_type_ref

    @property
    def advanced_config(self):
        """Gets the advanced_config of this PropertyRef.  # noqa: E501


        :return: The advanced_config of this PropertyRef.  # noqa: E501
        :rtype: PropertyAdvancedConfig
        """
        return self._advanced_config

    @advanced_config.setter
    def advanced_config(self, advanced_config):
        """Sets the advanced_config of this PropertyRef.


        :param advanced_config: The advanced_config of this PropertyRef.  # noqa: E501
        :type: PropertyAdvancedConfig
        """

        self._advanced_config = advanced_config

    @property
    def ontology_enum(self):
        """Gets the ontology_enum of this PropertyRef.  # noqa: E501


        :return: The ontology_enum of this PropertyRef.  # noqa: E501
        :rtype: str
        """
        return self._ontology_enum

    @ontology_enum.setter
    def ontology_enum(self, ontology_enum):
        """Sets the ontology_enum of this PropertyRef.


        :param ontology_enum: The ontology_enum of this PropertyRef.  # noqa: E501
        :type: str
        """
        allowed_values = [
            None,
            "TYPE",
            "PROPERTY",
            "RELATION",
            "SUB_PROPERTY",
            "CONCEPT",
        ]  # noqa: E501
        if (
            self.local_vars_configuration.client_side_validation
            and ontology_enum not in allowed_values
        ):  # noqa: E501
            raise ValueError(
                "Invalid value for `ontology_enum` ({0}), must be one of {1}".format(  # noqa: E501
                    ontology_enum, allowed_values
                )
            )

        self._ontology_enum = ontology_enum

    @property
    def project_id(self):
        """Gets the project_id of this PropertyRef.  # noqa: E501


        :return: The project_id of this PropertyRef.  # noqa: E501
        :rtype: int
        """
        return self._project_id

    @project_id.setter
    def project_id(self, project_id):
        """Sets the project_id of this PropertyRef.


        :param project_id: The project_id of this PropertyRef.  # noqa: E501
        :type: int
        """

        self._project_id = project_id

    @property
    def ontology_id(self):
        """Gets the ontology_id of this PropertyRef.  # noqa: E501


        :return: The ontology_id of this PropertyRef.  # noqa: E501
        :rtype: OntologyId
        """
        return self._ontology_id

    @ontology_id.setter
    def ontology_id(self, ontology_id):
        """Sets the ontology_id of this PropertyRef.


        :param ontology_id: The ontology_id of this PropertyRef.  # noqa: E501
        :type: OntologyId
        """

        self._ontology_id = ontology_id

    @property
    def alter_operation(self):
        """Gets the alter_operation of this PropertyRef.  # noqa: E501


        :return: The alter_operation of this PropertyRef.  # noqa: E501
        :rtype: str
        """
        return self._alter_operation

    @alter_operation.setter
    def alter_operation(self, alter_operation):
        """Sets the alter_operation of this PropertyRef.


        :param alter_operation: The alter_operation of this PropertyRef.  # noqa: E501
        :type: str
        """
        allowed_values = ["CREATE", "UPDATE", "DELETE"]  # noqa: E501
        if (
            self.local_vars_configuration.client_side_validation
            and alter_operation not in allowed_values
        ):  # noqa: E501
            raise ValueError(
                "Invalid value for `alter_operation` ({0}), must be one of {1}".format(  # noqa: E501
                    alter_operation, allowed_values
                )
            )

        self._alter_operation = alter_operation

    @property
    def ext_info(self):
        """Gets the ext_info of this PropertyRef.  # noqa: E501


        :return: The ext_info of this PropertyRef.  # noqa: E501
        :rtype: object
        """
        return self._ext_info

    @ext_info.setter
    def ext_info(self, ext_info):
        """Sets the ext_info of this PropertyRef.


        :param ext_info: The ext_info of this PropertyRef.  # noqa: E501
        :type: object
        """

        self._ext_info = ext_info

    def to_dict(self):
        """Returns the model properties as a dict"""
        result = {}

        for attr, _ in six.iteritems(self.openapi_types):
            value = getattr(self, attr)
            if isinstance(value, list):
                result[attr] = list(
                    map(lambda x: x.to_dict() if hasattr(x, "to_dict") else x, value)
                )
            elif hasattr(value, "to_dict"):
                result[attr] = value.to_dict()
            elif isinstance(value, dict):
                result[attr] = dict(
                    map(
                        lambda item: (item[0], item[1].to_dict())
                        if hasattr(item[1], "to_dict")
                        else item,
                        value.items(),
                    )
                )
            else:
                result[attr] = value

        return result

    def to_str(self):
        """Returns the string representation of the model"""
        return pprint.pformat(self.to_dict())

    def __repr__(self):
        """For `print` and `pprint`"""
        return self.to_str()

    def __eq__(self, other):
        """Returns true if both objects are equal"""
        if not isinstance(other, PropertyRef):
            return False

        return self.to_dict() == other.to_dict()

    def __ne__(self, other):
        """Returns true if both objects are not equal"""
        if not isinstance(other, PropertyRef):
            return True

        return self.to_dict() != other.to_dict()
