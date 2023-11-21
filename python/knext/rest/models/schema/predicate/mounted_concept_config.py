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


class MountedConceptConfig(object):
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
    openapi_types = {"concept_branch": "str", "concept_layer": "str"}

    attribute_map = {"concept_branch": "conceptBranch", "concept_layer": "conceptLayer"}

    def __init__(
        self, concept_branch=None, concept_layer=None, local_vars_configuration=None
    ):  # noqa: E501
        """MountedConceptConfig - a model defined in OpenAPI"""  # noqa: E501
        if local_vars_configuration is None:
            local_vars_configuration = Configuration()
        self.local_vars_configuration = local_vars_configuration

        self._concept_branch = None
        self._concept_layer = None
        self.discriminator = None

        if concept_branch is not None:
            self.concept_branch = concept_branch
        if concept_layer is not None:
            self.concept_layer = concept_layer

    @property
    def concept_branch(self):
        """Gets the concept_branch of this MountedConceptConfig.  # noqa: E501


        :return: The concept_branch of this MountedConceptConfig.  # noqa: E501
        :rtype: str
        """
        return self._concept_branch

    @concept_branch.setter
    def concept_branch(self, concept_branch):
        """Sets the concept_branch of this MountedConceptConfig.


        :param concept_branch: The concept_branch of this MountedConceptConfig.  # noqa: E501
        :type: str
        """

        self._concept_branch = concept_branch

    @property
    def concept_layer(self):
        """Gets the concept_layer of this MountedConceptConfig.  # noqa: E501


        :return: The concept_layer of this MountedConceptConfig.  # noqa: E501
        :rtype: str
        """
        return self._concept_layer

    @concept_layer.setter
    def concept_layer(self, concept_layer):
        """Sets the concept_layer of this MountedConceptConfig.


        :param concept_layer: The concept_layer of this MountedConceptConfig.  # noqa: E501
        :type: str
        """

        self._concept_layer = concept_layer

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
        if not isinstance(other, MountedConceptConfig):
            return False

        return self.to_dict() == other.to_dict()

    def __ne__(self, other):
        """Returns true if both objects are not equal"""
        if not isinstance(other, MountedConceptConfig):
            return True

        return self.to_dict() != other.to_dict()
