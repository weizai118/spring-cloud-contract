/*
 *  Copyright 2013-2017 the original author or authors.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.springframework.cloud.contract.verifier.util

/**
 * Represents content type. Used to pick the way bodies are parsed.
 *
 * @since 1.0.0
 */
enum ContentType {

	JSON("application/json"),
	XML("application/xml"),
	TEXT("text/plain"),
	UNKNOWN("application/octet-stream")

	final String mimeType

	ContentType(String mimeType) {
		this.mimeType = mimeType
	}

	static ContentType from(String header) {
		try {
			if (header.contains("json")) {
				return JSON
			} else if (header.contains("xml")) {
				return XML
			} else if (header.contains("text") ||
					header.contains("application/x-www-form-urlencoded")) {
				// we want both to be treated as text
				return TEXT
			}
		} catch(e) {}
		return UNKNOWN
	}

}